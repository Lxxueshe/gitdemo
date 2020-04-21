package cn.edu.scujcc.dao;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface ChannelRepository extends MongoRepository<Channel, String>{
	public ;List<Channel> findByTitleAndQuality(String t, String q);

}
