package web;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebListener;

import com.softalks.osjee.dropins.OsjeeDropins;

@WebListener
public class Listener extends OsjeeDropins {
	
	@Override
	public List<String> apply(Map<String, Object> configuration) {
		configuration.put("com.softalks.osjee.classes", "/");
		return super.apply(configuration);
	}
	
}