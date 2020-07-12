package car.utils;

public interface SQLQuery {
	
	String INSERT_INTO_CAR="insert into car_tbl(name,number, color, vendor, model, address, price, userid, password, role) values(?,?,?,?,?,?,?,?,?,?)";
	String SELECT_ALL_CAR="select  pid,name,number, color, vendor, model, address, price, userid, password, role from car_tbl";
	String CHECK_LOGIN_USER="select  pid,name,number, color, vendor, model, address, price, userid, password, role from car_tbl where userid  = ? and password = ?";
	String SELECT_PERSON_BY_PERSON_ID="select  pid,name,number, color, vendor, model, address, price, userid, password, role from car_tbl where userid  = ?";
	String DELETE_PERSON_BY_USERID="delete from car_tbl where userid  = ?";
	String GET_PROFILE = "select  pid,name,number, color, vendor, model, address, price, userid, password, role from car_tbl where userid  = ?";
	String UPDATE_CAR="update  car_tbl set name = ?, model =? , color = ?  , vendor = ? , price =? where userid = ?";
	String BLOCKER_TIME = "select pid, start_time, end_time from time_blocker_tbl";
	String SELECT_ALL_TIME="select  pid, start_time, end_time, active from time_blocker_tbl";
	String TIME_SELECTED="select start_time,end_time from time_blocker_tbl where active='Yes'";

}
