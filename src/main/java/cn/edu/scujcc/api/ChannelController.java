package cn.edu.scujcc.api;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.scujcc.model.Channel;
import cn.edu.scujcc.service.ChannelService;
/**
 * 频道接口
 * @author lx
 *
 */
@RestController
@RequestMapping("/channel")
public class ChannelController {
	public static final Logger logger = LoggerFactory.getLogger(ChannelController.class);
	/**
	 * 获取所有频道
	 * @return 所有频道接口的JSON数组
	 */
	@Autowired
	private ChannelService service;
	
	@GetMapping
	public List<Channel>getAllChannels() {
		    logger.info("正在查找所有频道消息");
		    List<Channel> results = service.getAllChannels();
		    logger.debug("所有频道的数量是："+ results.size());
		    
		    
			return results;
		}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Channel getChannel(@PathVariable int id) {
		System.out.println("获取频道：id="+id);
		
		if(id<=0) {
			Logger.warn("id的值有问题："+id);
		}
		Channel c= service.getChannel(id);
		if(c !=null) {
			return c;
		} else {
			Logger.error("找不到指定的频道");
			return null;
		}
		
	}
	/**
	 * 
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteChannel(@PathVariable int id){
		System.out.println("即将删除频道，id="+id);
		boolean result=service.deleteChannel(id);
		if(result) {
			return ResponseEntity.ok().body("删除成功.");
		}else {
			return ResponseEntity.ok().body("删除失败.");
		}
		
	}
	/**
	 * 
	 */
	@PostMapping
	public Channel createChannel(@RequestBody Channel c) {
		System.out.println("即将新建频道，频道数据："+c);
		Channel saved =service.createChannel(c);
		return saved;
	}
	@PutMapping
	public Channel updateChannel(@RequestBody Channel c) {
		System.out.println("即将更新频道，频道数据："+c);
		Channel updated =service.updateChannel(c);
		return updated;
	}
	@GetMapping("/s/{title}/{quality}")
	public List<Channel> search(@PathVariable String title, @PathVariable String quality){
		return service.search(title, quality);
	}

	}



