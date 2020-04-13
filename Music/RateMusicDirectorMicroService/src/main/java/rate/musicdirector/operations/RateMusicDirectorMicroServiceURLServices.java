package rate.musicdirector.operations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Getter
@Service
public class RateMusicDirectorMicroServiceURLServices {
	
	private String coreUrl;
	private final String detailsUrl="getdetails";
	private String finalUrl;
	
	public RateMusicDirectorMicroServiceURLServices(final @Value("${music.details.core}") String coreUrl) {
		this.coreUrl=coreUrl;
		this.finalUrl=this.coreUrl+"/"+detailsUrl+"?ID=";
	}
}
