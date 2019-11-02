package Demo.SQL.SQLDemo.Repository;

import Demo.SQL.SQLDemo.Model.LaptopRequest;

import Demo.SQL.SQLDemo.Model.LaptopSmall;
import Demo.SQL.SQLDemo.Services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface LaptopRequestRepository extends CrudRepository<LaptopRequest, Integer> {

    @PersistenceContext
    EntityManager entityManager = null ;

//  @Query( value = "SELECT new Demo.SQL.SQLDemo.Model.LaptopSmall(lp.requested_for_email, lp.end_date, lp.requested_by, lp.requested_date) FROM laptop_request lp WHERE lp.requested_for_email=:reqmail  limit 1 ", nativeQuery = true)
  @Query( value = "SELECT  lp.requested_for_email, lp.end_date, lp.requested_by, lp.requested_date,lp.requested_for FROM laptop_request lp WHERE lp.requested_for_email=:reqmail  limit 1 ", nativeQuery = true)
  List<List<String>> findByRequestedForEmail(@Param("reqmail") String requested_for_email);

  @Query(value="SELECT * from laptop_request", nativeQuery = true)
  List<LaptopRequest> findAllLaptop();


}
