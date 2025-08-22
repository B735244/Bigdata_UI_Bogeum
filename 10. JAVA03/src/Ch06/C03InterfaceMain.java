package Ch06;

interface Remote {
	int MAX_VOL = 100;// public static final
	int MIN_VOL = 0;// public static final

	void powerOn();// 미완성 된 추상 메서드

	void powerOff();// 미완성 된 추상 메서드

	void setVolume(int vol);
}


interface Browser{
	void SearchURL(String url);
}




class Tv implements Remote {// 추상 메서드 완성시킴
	private int nowVol;

	@Override
	public void powerOn() {

		System.out.println(" Tv를 켭니다.");
	}

	@Override
	public void powerOff() {

		System.out.println(" Tv를 끕니다");
	}

	public void setVolume(int vol) {
		if(vol>=MAX_VOL) {this.nowVol=MAX_VOL;}
		else if(vol<=MIN_VOL) {this.nowVol = MIN_VOL;}
		else
		this.nowVol= vol;
		
		System.out.println("TV의 현재 볼륨 :" + nowVol);
	}
	

}

class Radio implements Remote {// 추상 메서드 완성시킴
	private int nowVol;

	@Override
	public void powerOn() {

		System.out.println(" Radio를 켭니다.");
	}

	@Override
	public void powerOff() {

		System.out.println(" Radio를 끕니다.");
	}

	public void setVolume(int vol) {
		if(vol>=MAX_VOL) {this.nowVol=MAX_VOL;}
		else if(vol<=MIN_VOL) {this.nowVol = MIN_VOL;}
		else
		this.nowVol= vol;
		
		System.out.println("Radio의 현재 볼륨 :" + nowVol);
	}

}

class SmartTV extends Tv implements Browser {

	
	
	@Override
	public void SearchURL(String url) {
		System.out.println(url+ "로 이동합니다.");
		
		
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		super.powerOn();
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		super.powerOff();
	}

	@Override
	public void setVolume(int vol) {
		// TODO Auto-generated method stub
		super.setVolume(vol);
	}
	
	
	
}










public class C03InterfaceMain {
	public static void TurnOn(Remote controller) {
		controller.powerOn();
	
	}// TV/Radio 객체 Remote controller = new Tv();

	public static void TurnOff(Remote controller) {
		controller.powerOff();
	}// 함수 재정의
	
	public static void ChangeVolume(Remote controller , int vol) {
		controller.setVolume(vol);
		
	}
	
	public static void Internet(Browser browser, String Url) {
		browser.SearchURL(Url);
	}
	public static void main(String[] args) {
		Tv tv = new Tv();
		Radio radio = new Radio();
		SmartTV smarttv = new SmartTV();
		
		
		TurnOn(smarttv);
		ChangeVolume(smarttv,40);
		Internet(smarttv," www.google.com");
		TurnOff(smarttv);
		
		
	
		ChangeVolume(tv,50);
		ChangeVolume(radio,57);
	
		
		
		

	}

}
