package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.UserDetail;
import in.ineuron.dao.IUserDetailRepo;

@Service("service")
public class UserDetailMgmtServiceImpl implements IUserDetailMgmtService {

	@Autowired
	private IUserDetailRepo repo;

	@Override
	public Iterable<UserDetail> fetchAllDetailsByID(List<Long> ids) {
		return repo.findAllById(ids);
	}

	
	
	
}
	
	