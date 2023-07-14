package in.ineuron.dao;

import org.springframework.data.repository.CrudRepository;
import in.ineuron.bo.UserDetail;

public interface IUserDetailRepo extends CrudRepository<UserDetail, Long> {

}
