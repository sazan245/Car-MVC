package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import car.utils.SQLConnectionUtil;
import car.utils.SQLQuery;
import dao.entity.CarEntity;
import dao.entity.TimeEntity;

public class CarDaoImpl implements CarDao {
	@Override
	public String save(CarEntity entity) {
		int rowcount = 0;
		// Try with resource - Java7 features
		try (Connection conn = SQLConnectionUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQLQuery.INSERT_INTO_CAR);) {
			pstmt.setString(1, entity.getName());
			pstmt.setString(2, entity.getNumber());
			pstmt.setString(3, entity.getColor());
			pstmt.setString(4, entity.getVendor());
			pstmt.setString(5, entity.getModel());
			pstmt.setString(6, entity.getAddress());
			pstmt.setLong(7, entity.getPrice());
			pstmt.setString(8, entity.getUserid());
			pstmt.setString(9, entity.getPassword());
			pstmt.setString(10, entity.getRole());
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount > 0 ? "success" : "no rows updated";
	}

	@Override
	public List<CarEntity> findAll() {
		List<CarEntity> carEntities = new ArrayList<CarEntity>();
		try (Connection conn = SQLConnectionUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQLQuery.SELECT_ALL_CAR);) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CarEntity carEntity = new CarEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getLong(8), rs.getString(9),
						rs.getString(10), rs.getString(11));
				carEntities.add(carEntity);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return carEntities;
	}

	@Override
	public Optional<CarEntity> findLoginUser(String userid, String password) {
		CarEntity carEntity = null;
		try (Connection conn = SQLConnectionUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQLQuery.CHECK_LOGIN_USER)) {
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				carEntity = new CarEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getLong(8), rs.getString(9),
						rs.getString(10), rs.getString(11));
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(carEntity);
	}

	@Override
	public int deleteByEmailId(String userid) {
		int rowcount = 0;
		try (Connection conn = SQLConnectionUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQLQuery.DELETE_PERSON_BY_USERID)) {
			pstmt.setString(1, userid);
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}

	@Override
	public CarEntity findprofile(String userid) {
		CarEntity carEntity = null;
		try (Connection conn = SQLConnectionUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQLQuery.GET_PROFILE)) {
			pstmt.setString(1, userid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				carEntity = new CarEntity(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getLong(8), rs.getString(9),
						rs.getString(10), rs.getString(11));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carEntity;
	}
	
	@Override
	public void update(String userid, String name, String model, String color, String vendor, long price) {
		// Try with resource - Java7 features
		int row =0;
		try (Connection conn = SQLConnectionUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQLQuery.UPDATE_CAR);) {
			pstmt.setString(1, name);
			pstmt.setString(2, model);
			pstmt.setString(3, color);
			pstmt.setString(4, vendor);
			pstmt.setLong(5, price);
			pstmt.setString(6, userid);
			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (row > 0) {
			System.out.println("Record Updated Sucessfully");
		}
			}
	
	@Override
	public List<TimeEntity> findTime() {
		List<TimeEntity> timeEntities = new ArrayList<TimeEntity>();
		try (Connection conn = SQLConnectionUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SQLQuery.SELECT_ALL_TIME);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {				
				TimeEntity timeEntity = new TimeEntity(rs.getInt(1), rs.getTime(2), rs.getTime(3), rs.getString(4));
				timeEntities.add(timeEntity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return timeEntities;
	}


}
