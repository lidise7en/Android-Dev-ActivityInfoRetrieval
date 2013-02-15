package org.actvinfo.base;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.actvinfo.util.GeneralUtil;
import org.actvinfo.*;

import android.R;

public class ActivityInfoSet {
	private TreeSet<ActivityInfo> activitySet;
	public Calendar currentTime;
	
	public ActivityInfoSet() {
		currentTime = Calendar.getInstance();
		Comparator<ActivityInfo> comparator = new Comparator<ActivityInfo>(){
			public int compare(ActivityInfo o1, ActivityInfo o2) {
				return o1.compareTo(o2);
			}
		};
		activitySet = new TreeSet<ActivityInfo>(comparator);
		add4Test();
	}
	
	private void add4Test() {
		Calendar time = Calendar.getInstance();
		time.set(2011, Calendar.DECEMBER, 26, 16, 0);
		ActivityInfo ai = new ActivityInfo("清华信息大讲堂第81讲--Spectrum Sharing in " +
				"Multihop Cognitive Relay Networks", "Wei Zhang", 
				"School of Electrical Engineering & Telecommunications at the " +
				"University of New South Wales, Sydney Australia", time,
				ActivityInfo.Building.FIT, "1-415 会议室", "信息学院",
				"Cognitive radio is a novel and promising communications paradigm to address the spectrum insufficiency problem by employing dynamic spectrum access technologies to utilize the licensed spectrum flexibly and sufficiently. In cognitive radio networks, unlicensed cognitive users can access the radio spectrum together with the licensed primary users (PUs) when the spectrum is not occupied by the PUs (white space) or when the spectrum is partially occupied by low power distant PUs and the incurred interference to the PUs is below a predetermined interference temperature limit (grey space). In this work, we develop a novel “whispering radio” technique by utilizing multihop relay techniques and smart power control to take full advantage of the “grey space” of the licensed spectrum. The proposed “whispering radio” can maximize the spectrum utilization efficiency by allowing cognitive radios to access the licensed band even when the primary user is in operation.\n\nWei Zhang (S’01, M’06, SM’11) received the Ph.D. degree in Electronic Engineering from the Chinese University of Hong Kong in 2005. He was a Research Fellow at the Department of Electronic and Computer Engineering, Hong Kong University of Science and Technology in 2006-2007. From 2008, he has been with the School of Electrical Engineering & Telecommunications at the University of New South Wales, Sydney Australia, where he is a Senior Lecturer. He held visiting positions at Chinese University of Hong Kong, Hong Kong University of Science and Technology, University of Delaware, and Princeton University.\n\nHis current research interests include cognitive radio, cooperative communications, space-time coding, and multi-user MIMO. He received the best paper award at the 50th IEEE Global Communications Conference (GLOBECOM), Washington DC in 2007 and the IEEE Communications Society Asia-Pacific Outstanding Young Researcher Award in 2009.\n\nHe is an Editor of IEEE Transactions on Wireless Communications and an Editor of IEEE Journal on Selected Areas in Communications - Cognitive Radio Series. He serves as a TPC Co-Chair of Communications Theory Symposium of IEEE ICC 2011, a TPC Co-Chair of Wireless Communications Symposium of IEEE ICCCAS 2009, and Guest Editor of Journal of Communications special issue on “Cognitive Radio Enabled Communications and Networking” and special issue on “Coding and Modulation for Cooperative Communications”. He has been serving as a TPC member of many IEEE conferences including ICC, GLOBECOM, WCNC, DySPAN, etc. He is a Senior Member of the IEEE.");
		ai.setType(ActivityInfo.Category.COMPSCIENG);
		activitySet.add(ai);
		
		time = Calendar.getInstance();
		time.set(2011, Calendar.DECEMBER, 29, 15, 20);
		ai = new ActivityInfo("清华大学新人文讲座系列之（十）艺术人文第十七讲暨韩美林艺术大展系列活动之“高校论坛”：传承与超越——我的艺术观",
				"韩美林", 	"清华大学教授、学术委员会副主任", time, ActivityInfo.Building.LIUJIAO,
				"", "国家大学生文化素质教育基地",
				"演讲人简介：韩美林，生于1936年12月26日，山东济南人，毕业于中央工艺美术学院。现任全国政协常委，中央文史研究馆馆员，中国美术家协会陶瓷艺术委员会主任，世界华人协会副会长，中国文化研究院荣誉院士，中国工艺美术学会书画委员会会长，中国和平统一促进会常务委员，中国作家协会创作研究部专业作家，清华大学教授、学术委员会副主任，中国艺术研究院研究生院博士生导师。\n韩美林先生是一位孜孜不倦的艺术实践者和开拓者，其创作涉及广泛，包括绘画、书法、雕塑、陶瓷、民间艺术、标志设计乃至写作等等。其艺术风格独到，致力于从中国两汉以前文化和民间艺术中汲取精髓，并转化为体现现代审美理念的艺术作品。代表作有：书法作品古文字集录《天书》，巨型城市雕塑《迎风长啸》、《大舜耕田》、《五云九如》、《钱江龙》、《钱王射潮》、《火凤凰》、《火凤迎祥》、《百鸟朝凤》，设计作品有中国国际航空公司航徽、奥运吉祥物福娃等，作品集《山花烂漫》、《美林》、《韩美林自选雕塑集》，《韩美林自选绘画集》，散文集《闲言碎语》、《韩美林自述》、《韩美林散文》、《豆蔻梢头——韩美林人体艺术作品集》、《几回明月——韩美林课徒人体画稿选》、《嚥山嚼水——韩美林山水画集》《良弓在手——韩美林书法作品集》等等。\n其艺术成就斐然：1980年于美国21个城市举办巡回画展，并获得美国圣地亚哥市赠予的“金钥匙”，同年，他创作的动画片《狐狸打猎人》获得南斯拉夫第四届萨格拉布国际动漫电影节最佳美术奖；1983年，韩先生的6幅作品入选联合国发行的圣诞卡；2003年，荣获世界艺术家协会（美）世界艺术贡献奖；2004年，获世界艺术家协会（美）颁发的世界艺术大师奖和美国前总统布什颁发的总统教育奖。在推动和促进艺术文化发展和交流方面，韩先生也做出了突出的贡献，他曾多次应邀到日本、印度等国进行文化交流和访问。2011年被环球时报评为“最受全球关注的中国人物”榜首。在中国的北京、杭州两地均建有韩美林艺术馆。");
		ai.setType(ActivityInfo.Category.CULTLECTURE);
		activitySet.add(ai);
		
		time = Calendar.getInstance();
		time.set(2012, Calendar.JANUARY, 6, 13, 00);
		ai = new ActivityInfo("清华大学新人文讲座系列之（十一）艺术人文第十八讲暨韩美林艺术大展系列活动之“高校论坛”：传承与超越——我的艺术观",
				"韩美林", 	"清华大学教授、学术委员会副主任", time, ActivityInfo.Building.LIUJIAO,
				"", "国家大学生文化素质教育基地",
				"演讲人简介：韩美林，生于1936年12月26日，山东济南人，毕业于中央工艺美术学院。现任全国政协常委，中央文史研究馆馆员，中国美术家协会陶瓷艺术委员会主任，世界华人协会副会长，中国文化研究院荣誉院士，中国工艺美术学会书画委员会会长，中国和平统一促进会常务委员，中国作家协会创作研究部专业作家，清华大学教授、学术委员会副主任，中国艺术研究院研究生院博士生导师。\n韩美林先生是一位孜孜不倦的艺术实践者和开拓者，其创作涉及广泛，包括绘画、书法、雕塑、陶瓷、民间艺术、标志设计乃至写作等等。其艺术风格独到，致力于从中国两汉以前文化和民间艺术中汲取精髓，并转化为体现现代审美理念的艺术作品。代表作有：书法作品古文字集录《天书》，巨型城市雕塑《迎风长啸》、《大舜耕田》、《五云九如》、《钱江龙》、《钱王射潮》、《火凤凰》、《火凤迎祥》、《百鸟朝凤》，设计作品有中国国际航空公司航徽、奥运吉祥物福娃等，作品集《山花烂漫》、《美林》、《韩美林自选雕塑集》，《韩美林自选绘画集》，散文集《闲言碎语》、《韩美林自述》、《韩美林散文》、《豆蔻梢头——韩美林人体艺术作品集》、《几回明月——韩美林课徒人体画稿选》、《嚥山嚼水——韩美林山水画集》《良弓在手——韩美林书法作品集》等等。\n其艺术成就斐然：1980年于美国21个城市举办巡回画展，并获得美国圣地亚哥市赠予的“金钥匙”，同年，他创作的动画片《狐狸打猎人》获得南斯拉夫第四届萨格拉布国际动漫电影节最佳美术奖；1983年，韩先生的6幅作品入选联合国发行的圣诞卡；2003年，荣获世界艺术家协会（美）世界艺术贡献奖；2004年，获世界艺术家协会（美）颁发的世界艺术大师奖和美国前总统布什颁发的总统教育奖。在推动和促进艺术文化发展和交流方面，韩先生也做出了突出的贡献，他曾多次应邀到日本、印度等国进行文化交流和访问。2011年被环球时报评为“最受全球关注的中国人物”榜首。在中国的北京、杭州两地均建有韩美林艺术馆。");
		ai.setType(ActivityInfo.Category.CULTLECTURE);
		activitySet.add(ai);
		
		time = Calendar.getInstance();
		time.set(2012, Calendar.JANUARY, 8, 19, 00);
		ai = new ActivityInfo("清华大学中国与世界经济论坛（十）——2012 ？！",
				"李稻葵", 	"清华大学中国与世界经济研究中心主任", time, ActivityInfo.Building.SANJIAO,
				"", "清华大学中国与世界经济研究中心、清华大学经济管理学院校友事务办公室",
				"2012中国龙年即将来临。在中国人心中，龙是呼风唤雨，腾云驾雾的神物，也有难以捉摸，变幻莫测的特质。龙年被中国人认为具有很强的运势。萧条减速可能是养精蓄锐的好机会，一旦突破艰难困苦，就会有更强劲的气势前进。当今世界政治经济大局，似乎也与龙年呼应。");
		ai.setType(ActivityInfo.Category.CULTLECTURE);
		activitySet.add(ai);
	}
	
	public List<Map<String, Object>> getActvList() { 
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(); 
        Map<String, Object> map;
        
        Iterator<ActivityInfo> it = activitySet.iterator();
        while (it.hasNext()) {
        	ActivityInfo ai = it.next();
        	map = new HashMap<String, Object>();
        	map.put("time", GeneralUtil.getDisplay(GeneralUtil.Style.ALL2LINE,
        			ai.getDisplayDate(currentTime), ai.getDisplayClock()));
        	map.put("subject", ai.getSubject());
        	map.put("speaker", ai.getSpeakerName());
        	map.put("dscp", ai.getDescription());
        	map.put("img", ai.getTypeDrawable());
        	map.put("location", ai.getDisplayLocation());
        	list.add(map);
        }
        /*
        map.put("time", "2012-1-1\n12:00");
        map.put("subject", "G1"); 
        map.put("speaker", "XCX");
        map.put("dscp", "google 1"); 
        map.put("img", R.drawable.favorite_press); 
        list.add(map);   

        map = new HashMap<String, Object>(); 
        map.put("time", "2012-1-2\n12:00");
        map.put("subject", "G2"); 
        map.put("speaker", "XCX");
        map.put("dscp", "google 2"); 
        map.put("img", R.drawable.favorite_normal); 
        list.add(map); 

  

        map = new HashMap<String, Object>(); 
        map.put("time", "2012-1-3\n12:00");
        map.put("subject", "G3"); 
        map.put("speaker", "XCX");
        map.put("dscp", "google 3"); 
        map.put("img", R.drawable.favorite_press); 
        list.add(map); 

        
        map = new HashMap<String, Object>(); 
        map.put("time", "2012-1-3\n12:00");
        map.put("subject", "G4"); 
        map.put("speaker", "XCX");
        map.put("dscp", "google 3"); 
        map.put("img", R.drawable.favorite_press); 
        list.add(map); 
        
        map = new HashMap<String, Object>(); 
        map.put("time", "2012-1-3\n12:00");
        map.put("subject", "G5"); 
        map.put("speaker", "XCX");
        map.put("dscp", "google 3"); 
        map.put("img", R.drawable.favorite_press); 
        list.add(map); 
        */
        
        return list; 
    }
	/*
	 * Return a ArrayList of activities in the order of BuildingLocation
	 */
	public ArrayList<ActivityInfo> getActivities() {
		
		ArrayList<ActivityInfo> actArray = new ArrayList<ActivityInfo>();
		Iterator<ActivityInfo> it = activitySet.iterator();
		
		//int time = 0;
		
		while(it.hasNext()) {
			//Log.d("mygmap", String.valueOf(time));
			actArray.add(it.next());
			//time++;
		}
		
		/*
		if(actArray.size() < 3)
		{
			ActivityInfo tmp = actArray.get(0);
			actArray.remove(0);
			tmp.setSubject("bbb");
			actArray.add(tmp);
		}
		*/
		Comparator<ActivityInfo> comparator = new Comparator<ActivityInfo>(){
			public int compare(ActivityInfo o1, ActivityInfo o2) {
				//return o1.getLocBuilding().compareTo(o2.getLocBuilding());
				return o1.getLocBuilding().ordinal() - o2.getLocBuilding().ordinal();
			}
		};
		
		Collections.sort(actArray, comparator);
		return actArray;
	}
}
