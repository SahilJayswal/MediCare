package com.medicare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicare.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	/*
	 * public static final JdbcTemplate template = new JdbcTemplate();
	 * 
	 * class ProductRowMapper implements RowMapper<User>{
	 * 
	 * @Override public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	 * User u = new User(); u.setId(rs.getInt(1)); u.setFirstName(rs.getString(2));
	 * u.setLastName(rs.getString(3)); u.setEmail(rs.getString(4));
	 * u.setPassword(rs.getString(5)); return u; }
	 * 
	 * }
	 */
	
	
}
