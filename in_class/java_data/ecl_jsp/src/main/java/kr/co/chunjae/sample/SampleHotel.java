package kr.co.chunjae.sample;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
//@RequiredArgsConstructor
public class SampleHotel {
	
	// @Autowired
	// @Autowired를 annotate 하지 않아도 자동 주입된다. (Spring 4.3 ~ )
	private Chef chef;

	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	/*
	 * @NonNull private Chef chef;
	 */
}
