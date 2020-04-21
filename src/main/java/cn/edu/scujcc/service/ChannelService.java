package cn.edu.scujcc.service;
import java.util.ArrayList;
import java.util.List;

import cn.edu.scujcc.model.Channel;
@Service
public class ChannelService {
	@Autowired
	private ChannelRepository repo;
	
	
	
	l
	public ChannelService() {
		channels =new ArrayList<>();
		for(int i=0;i<10;i++) {
			Channel c= new Channel();
			c.setId(i+1);
			c.setTitle("中央"+(i+1)+"台");
			c.setUrl("http://www.cctv.com");
			channels.add(c);
		}
		
	}

	public List<Channel>getAllChannels(){
		return repo.findAll();
	}
	
	
	
	public Channel getChannel(int channelId) {
		Channel result =null;
		//循环查找指定的频道
		for (Channel c:channels) {
//			if(c.getId() == channelId) {
//				result=c;
//				break;
		//	}
	
		}
	return result;
	}
	public boolean deleteChannel(int channelId) {
		boolean result=false;
		Channel c=getChannel(channelId);
		if(c !=null) {
			channels.remove(c);
			result=true;
		}
		return result;
	}
	public Channel createChannel(Channel c) {
		return repo.save(c);
	}
	
	
	public Channel updateChannel(Channel c) {
		return null;
	}
	public List<Channel> search(String titlt,String quality){
		return repo.findByTitleAndQuality(title,quality);
	}
}
