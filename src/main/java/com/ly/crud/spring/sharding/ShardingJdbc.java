package com.ly.crud.spring.sharding;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;

public class ShardingJdbc {

	public static void main(String[] args) throws SQLException {
		// 数据源
		Map<String, DataSource> dataSourceMap = new HashMap<>(2);
		dataSourceMap.put("db0", createDataSource("db0"));
//		dataSourceMap.put("db1", createDataSource("db1"));
		DataSourceRule dataSourceRule = new DataSourceRule(dataSourceMap);

		TableRule orderTableRule = TableRule.builder("t_order").actualTables(Arrays.asList("t_order_0", "t_order_1"))
				.dataSourceRule(dataSourceRule).build();
		
		TableRule orderItemTableRule = TableRule.builder("t_order_item")
				.actualTables(Arrays.asList("t_order_item_0", "t_order_item_1")).dataSourceRule(dataSourceRule).build();
		
		ShardingRule shardingRule = ShardingRule.builder().dataSourceRule(dataSourceRule)
				.tableRules(Arrays.asList(orderTableRule, orderItemTableRule))
				.tableShardingStrategy(new TableShardingStrategy("order_id", new ModuloTableShardingAlgorithm()))
				.build();
		
		DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
		Connection conn = dataSource.getConnection();
		
			try{
			//	insertOrdderTable(conn);
				leftjoinQuery(conn);
			}finally{
				conn.close();
			}
			
		   
	}

	private static void leftjoinQuery(Connection conn) throws SQLException {
		String sql = "select * from t_order o left join t_product p on o.product_id=p.product_id order by o.order_id ";
		    PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getString(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getString(3)+"\t");
				System.out.print(rs.getString(4)+"\t");
				System.out.print(rs.getString(5)+"\t");
				System.out.println();
			}
	}

	private static void insertOrderTable(Connection conn) throws SQLException {
		String sql = "INSERT INTO  t_order(user_id,order_id,product_id) VALUES (?, ?,?)";
	
		
		for(int i = 1;i<=10;i++){
			PreparedStatement pstmt;
			try {
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setInt(1, 2);  //userid为偶数时为db0
				pstmt.setInt(2, i);
				pstmt.setInt(2, i/5);
				pstmt.execute();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 创建数据源
	 * 
	 * @param dataSourceName
	 * @return
	 */
	private static DataSource createDataSource(String dataSourceName) {
		BasicDataSource result = new BasicDataSource();
		result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
		result.setUrl(String.format("jdbc:mysql://localhost:3306/%s", dataSourceName));
		result.setUsername("root");
		result.setPassword("liyang");
		return result;
	}

}
