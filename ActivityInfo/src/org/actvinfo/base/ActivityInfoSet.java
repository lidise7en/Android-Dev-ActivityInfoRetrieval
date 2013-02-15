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
		ActivityInfo ai = new ActivityInfo("�廪��Ϣ���õ�81��--Spectrum Sharing in " +
				"Multihop Cognitive Relay Networks", "Wei Zhang", 
				"School of Electrical Engineering & Telecommunications at the " +
				"University of New South Wales, Sydney Australia", time,
				ActivityInfo.Building.FIT, "1-415 ������", "��ϢѧԺ",
				"Cognitive radio is a novel and promising communications paradigm to address the spectrum insufficiency problem by employing dynamic spectrum access technologies to utilize the licensed spectrum flexibly and sufficiently. In cognitive radio networks, unlicensed cognitive users can access the radio spectrum together with the licensed primary users (PUs) when the spectrum is not occupied by the PUs (white space) or when the spectrum is partially occupied by low power distant PUs and the incurred interference to the PUs is below a predetermined interference temperature limit (grey space). In this work, we develop a novel ��whispering radio�� technique by utilizing multihop relay techniques and smart power control to take full advantage of the ��grey space�� of the licensed spectrum. The proposed ��whispering radio�� can maximize the spectrum utilization efficiency by allowing cognitive radios to access the licensed band even when the primary user is in operation.\n\nWei Zhang (S��01, M��06, SM��11) received the Ph.D. degree in Electronic Engineering from the Chinese University of Hong Kong in 2005. He was a Research Fellow at the Department of Electronic and Computer Engineering, Hong Kong University of Science and Technology in 2006-2007. From 2008, he has been with the School of Electrical Engineering & Telecommunications at the University of New South Wales, Sydney Australia, where he is a Senior Lecturer. He held visiting positions at Chinese University of Hong Kong, Hong Kong University of Science and Technology, University of Delaware, and Princeton University.\n\nHis current research interests include cognitive radio, cooperative communications, space-time coding, and multi-user MIMO. He received the best paper award at the 50th IEEE Global Communications Conference (GLOBECOM), Washington DC in 2007 and the IEEE Communications Society Asia-Pacific Outstanding Young Researcher Award in 2009.\n\nHe is an Editor of IEEE Transactions on Wireless Communications and an Editor of IEEE Journal on Selected Areas in Communications - Cognitive Radio Series. He serves as a TPC Co-Chair of Communications Theory Symposium of IEEE ICC 2011, a TPC Co-Chair of Wireless Communications Symposium of IEEE ICCCAS 2009, and Guest Editor of Journal of Communications special issue on ��Cognitive Radio Enabled Communications and Networking�� and special issue on ��Coding and Modulation for Cooperative Communications��. He has been serving as a TPC member of many IEEE conferences including ICC, GLOBECOM, WCNC, DySPAN, etc. He is a Senior Member of the IEEE.");
		ai.setType(ActivityInfo.Category.COMPSCIENG);
		activitySet.add(ai);
		
		time = Calendar.getInstance();
		time.set(2011, Calendar.DECEMBER, 29, 15, 20);
		ai = new ActivityInfo("�廪��ѧ�����Ľ���ϵ��֮��ʮ���������ĵ�ʮ�߽��ߺ�����������չϵ�л֮����У��̳���������볬Խ�����ҵ�������",
				"������", 	"�廪��ѧ���ڡ�ѧ��ίԱ�ḱ����", time, ActivityInfo.Building.LIUJIAO,
				"", "���Ҵ�ѧ���Ļ����ʽ�������",
				"�ݽ��˼�飺�����֣�����1936��12��26�գ�ɽ�������ˣ���ҵ�����빤������ѧԺ������ȫ����Э��ί��������ʷ�о��ݹ�Ա���й�������Э���մ�����ίԱ�����Σ����绪��Э�ḱ�᳤���й��Ļ��о�Ժ����Ժʿ���й���������ѧ���黭ίԱ��᳤���й���ƽͳһ�ٽ��᳣��ίԱ���й�����Э�ᴴ���о���רҵ���ң��廪��ѧ���ڡ�ѧ��ίԱ�ḱ���Σ��й������о�Ժ�о���Ժ��ʿ����ʦ��\n������������һλ���β��������ʵ���ߺͿ����ߣ��䴴���漰�㷺�������滭���鷨�����ܡ��մɡ������������־�������д���ȵȡ��������������������ڴ��й�������ǰ�Ļ�����������м�ȡ���裬��ת��Ϊ�����ִ����������������Ʒ���������У��鷨��Ʒ�����ּ�¼�����顷�����ͳ��е��ܡ�ӭ�糤Х��������˴����������ƾ��硷����Ǯ����������Ǯ���䳱���������ˡ��������ӭ�顷�������񳯷�������Ʒ���й����ʺ��չ�˾���ա����˼����︣�޵ȣ���Ʒ����ɽ���������������֡�������������ѡ���ܼ���������������ѡ�滭������ɢ�ļ������������������������������������ɢ�ġ�������ޢ��ͷ��������������������Ʒ���������������¡��������ֿ�ͽ���廭��ѡ��������ɽ��ˮ����������ɽˮ���������������֡����������鷨��Ʒ�����ȵȡ�\n�������ɾ��Ȼ��1980��������21�����оٰ�Ѳ�ػ�չ�����������ʥ���Ǹ�������ġ���Կ�ס���ͬ�꣬�������Ķ���Ƭ����������ˡ������˹������Ľ������������ʶ�����Ӱ�������������1983�꣬��������6����Ʒ��ѡ���Ϲ����е�ʥ������2003�꣬�ٻ�����������Э�ᣨ���������������׽���2004�꣬������������Э�ᣨ�����䷢������������ʦ��������ǰ��ͳ��ʲ�䷢����ͳ�����������ƶ��ʹٽ������Ļ���չ�ͽ������棬������Ҳ������ͻ���Ĺ��ף��������Ӧ�����ձ���ӡ�ȵȹ������Ļ������ͷ��ʡ�2011�걻����ʱ����Ϊ������ȫ���ע���й�������ס����й��ı������������ؾ����к����������ݡ�");
		ai.setType(ActivityInfo.Category.CULTLECTURE);
		activitySet.add(ai);
		
		time = Calendar.getInstance();
		time.set(2012, Calendar.JANUARY, 6, 13, 00);
		ai = new ActivityInfo("�廪��ѧ�����Ľ���ϵ��֮��ʮһ���������ĵ�ʮ�˽��ߺ�����������չϵ�л֮����У��̳���������볬Խ�����ҵ�������",
				"������", 	"�廪��ѧ���ڡ�ѧ��ίԱ�ḱ����", time, ActivityInfo.Building.LIUJIAO,
				"", "���Ҵ�ѧ���Ļ����ʽ�������",
				"�ݽ��˼�飺�����֣�����1936��12��26�գ�ɽ�������ˣ���ҵ�����빤������ѧԺ������ȫ����Э��ί��������ʷ�о��ݹ�Ա���й�������Э���մ�����ίԱ�����Σ����绪��Э�ḱ�᳤���й��Ļ��о�Ժ����Ժʿ���й���������ѧ���黭ίԱ��᳤���й���ƽͳһ�ٽ��᳣��ίԱ���й�����Э�ᴴ���о���רҵ���ң��廪��ѧ���ڡ�ѧ��ίԱ�ḱ���Σ��й������о�Ժ�о���Ժ��ʿ����ʦ��\n������������һλ���β��������ʵ���ߺͿ����ߣ��䴴���漰�㷺�������滭���鷨�����ܡ��մɡ������������־�������д���ȵȡ��������������������ڴ��й�������ǰ�Ļ�����������м�ȡ���裬��ת��Ϊ�����ִ����������������Ʒ���������У��鷨��Ʒ�����ּ�¼�����顷�����ͳ��е��ܡ�ӭ�糤Х��������˴����������ƾ��硷����Ǯ����������Ǯ���䳱���������ˡ��������ӭ�顷�������񳯷�������Ʒ���й����ʺ��չ�˾���ա����˼����︣�޵ȣ���Ʒ����ɽ���������������֡�������������ѡ���ܼ���������������ѡ�滭������ɢ�ļ������������������������������������ɢ�ġ�������ޢ��ͷ��������������������Ʒ���������������¡��������ֿ�ͽ���廭��ѡ��������ɽ��ˮ����������ɽˮ���������������֡����������鷨��Ʒ�����ȵȡ�\n�������ɾ��Ȼ��1980��������21�����оٰ�Ѳ�ػ�չ�����������ʥ���Ǹ�������ġ���Կ�ס���ͬ�꣬�������Ķ���Ƭ����������ˡ������˹������Ľ������������ʶ�����Ӱ�������������1983�꣬��������6����Ʒ��ѡ���Ϲ����е�ʥ������2003�꣬�ٻ�����������Э�ᣨ���������������׽���2004�꣬������������Э�ᣨ�����䷢������������ʦ��������ǰ��ͳ��ʲ�䷢����ͳ�����������ƶ��ʹٽ������Ļ���չ�ͽ������棬������Ҳ������ͻ���Ĺ��ף��������Ӧ�����ձ���ӡ�ȵȹ������Ļ������ͷ��ʡ�2011�걻����ʱ����Ϊ������ȫ���ע���й�������ס����й��ı������������ؾ����к����������ݡ�");
		ai.setType(ActivityInfo.Category.CULTLECTURE);
		activitySet.add(ai);
		
		time = Calendar.getInstance();
		time.set(2012, Calendar.JANUARY, 8, 19, 00);
		ai = new ActivityInfo("�廪��ѧ�й������羭����̳��ʮ������2012 ����",
				"���", 	"�廪��ѧ�й������羭���о���������", time, ActivityInfo.Building.SANJIAO,
				"", "�廪��ѧ�й������羭���о����ġ��廪��ѧ���ù���ѧԺУ������칫��",
				"2012�й����꼴�����١����й������У����Ǻ��绽�꣬���Ƽ�������Ҳ������׽�������Ī������ʡ����걻�й�����Ϊ���к�ǿ�����ơ��������ٿ�������������ĺû��ᣬһ��ͻ�Ƽ������࣬�ͻ��и�ǿ��������ǰ���������������ξ��ô�֣��ƺ�Ҳ�������Ӧ��");
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
