package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import in.ineuron.bo.UserDetail;

public interface IUserDetailMgmtService {
	
	public Iterable<UserDetail> fetchAllDetailsByID(List<Long> ids);
	
}
