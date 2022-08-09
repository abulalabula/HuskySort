package edu.neu.coe.huskySort.sort.huskySortUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import edu.neu.coe.huskySort.sort.radix.MSDStringBPMFSort;
import edu.neu.coe.huskySort.util.Benchmark;

public class TestChinese {
	
	
	@Test
    public void testConvertToPinyinTime1() {
		final String Chinese = "准晚塑并腰混尘肃剩割言竟员漆剂畅彼泰谨页";
		Consumer<String> consumer = (f) -> {
			final String pinyin = ChineseCharacter.convertToPinyin(Chinese);
    	final String[] tokens = ChineseCharacter.parsePinyin(pinyin, Chinese.length());
    	HashMap<String,String> content = new HashMap<String, String>();
    	for(int i = 0; i < Chinese.length(); i++) {
    		while(!content.getOrDefault(tokens[i], "0").equals("0")){
                tokens[i] += " ";
            }
    		content.put(tokens[i], String.valueOf(Chinese.charAt(i)));
    	}
        //MSDStringSort
        final MSDStringBPMFSort msdBPMFStringSort = new MSDStringBPMFSort();
        msdBPMFStringSort.sort(tokens);
		};
        Benchmark<String> benchMark = new Benchmark<String>("result",consumer);
		double time = benchMark.run(Chinese, 1000);
		System.out.println("Sort 20 Chinese characters: "+time+" ms");
    }
	
	@Test
    public void testConvertToPinyinTime2() {
		final String Chinese = "企谁走欢城裕健激访重星宋起甲用谢俘至骄笛塑柔泄虎浅力最轮粘恐屿损到终冒秒括语诊凡";
		Consumer<String> consumer = (f) -> {
			final String pinyin = ChineseCharacter.convertToPinyin(Chinese);
    	final String[] tokens = ChineseCharacter.parsePinyin(pinyin, Chinese.length());
    	HashMap<String,String> content = new HashMap<String, String>();
    	for(int i = 0; i < Chinese.length(); i++) {
    		while(!content.getOrDefault(tokens[i], "0").equals("0")){
                tokens[i] += " ";
            }
    		content.put(tokens[i], String.valueOf(Chinese.charAt(i)));
    	}
        //MSDStringSort
        final MSDStringBPMFSort msdBPMFStringSort = new MSDStringBPMFSort();
        msdBPMFStringSort.sort(tokens);
		};
        Benchmark<String> benchMark = new Benchmark<String>("result",consumer);
		double time = benchMark.run(Chinese, 1000);
		System.out.println("Sort 40 Chinese characters: "+time+" ms");
    }
	
	@Test
    public void testConvertToPinyinTime3() {
		final String Chinese = "塞一坝痒适抛躲苹芽皂量航昏伞按销老疏奇受番宁暮地摔删之身男清粥止虫杠始朽吵租赤尼脉漆映装右吊赔港堪滚又度洪逝廊凤蛙悄喷淡副景辉礼肾占盼旷侄涂届劝煮同垃导龟热普炎";
		Consumer<String> consumer = (f) -> {
			final String pinyin = ChineseCharacter.convertToPinyin(Chinese);
    	final String[] tokens = ChineseCharacter.parsePinyin(pinyin, Chinese.length());
    	HashMap<String,String> content = new HashMap<String, String>();
    	for(int i = 0; i < Chinese.length(); i++) {
    		while(!content.getOrDefault(tokens[i], "0").equals("0")){
                tokens[i] += " ";
            }
    		content.put(tokens[i], String.valueOf(Chinese.charAt(i)));
    	}
        //MSDStringSort
        final MSDStringBPMFSort msdBPMFStringSort = new MSDStringBPMFSort();
        msdBPMFStringSort.sort(tokens);
		};
        Benchmark<String> benchMark = new Benchmark<String>("result",consumer);
		double time = benchMark.run(Chinese, 1000);
		System.out.println("Sort 80 Chinese characters: "+time+" ms");
    }
	
	@Test
    public void testConvertToPinyinTime4() {
		final String Chinese = "奇伙易母海深薯录秆洁伴路笋使誉轿呢巨递扁稠稿嘴掘川覆漠笑滴润既锁骡信献尚夺粱洲墓惧屿备详更慕善警讯七横适芹鉴伶容月总亚拦谈参骆煌特支距欢剂垃班买工抽念扣定脑二风岗共起陵井财意似乔归绸内阻抹济赌她甜堡炕怜士又珍谷服填记赴赤虽樱私催远译坑裂腹俘浑额哄随合洞框弊银器越丽袍客素勾净管搁域哑担子锣狭采壶论厕无敏释钳姑茧蠢文同辉馒";
		Consumer<String> consumer = (f) -> {
			final String pinyin = ChineseCharacter.convertToPinyin(Chinese);
    	final String[] tokens = ChineseCharacter.parsePinyin(pinyin, Chinese.length());
    	HashMap<String,String> content = new HashMap<String, String>();
    	for(int i = 0; i < Chinese.length(); i++) {
    		while(!content.getOrDefault(tokens[i], "0").equals("0")){
                tokens[i] += " ";
            }
    		content.put(tokens[i], String.valueOf(Chinese.charAt(i)));
    	}
        //MSDStringSort
        final MSDStringBPMFSort msdBPMFStringSort = new MSDStringBPMFSort();
        msdBPMFStringSort.sort(tokens);
		};
        Benchmark<String> benchMark = new Benchmark<String>("result",consumer);
		double time = benchMark.run(Chinese, 1000);
		System.out.println("Sort 160 Chinese characters: "+time+" ms");
    }
	
	@Test
    public void testConvertToPinyinTime5() {
		final String Chinese = "圣饺暖纷饲钢遥海雅橘粮貌艳撞敏核禽择烟厌茂延少辫尼贼钳疏献疫没搂伴缓变施尾峡剧前境惧坦形蚕殊烂池其故慎僻守老囊江姐博下偿持法亿航剑较入丝剖挤只伏月坚计怒鸣黄宾乔雪送芦洁恳关振末策亮民着携番密摘煎出瞒怜告催泥像在招塌亩鞭劝应唐丈汁示醉桐电掌检刃狂祸望碗膊铜洞敌贷炸脂枝渗收乡碌烫肯霉洗杂秘孙诗踏举乞驾您蔑鸭蜡草茎醒奔饭帐按伐晒墓特彩谦参朗浊哀每失宏葱键趁歪奋互风展总裂丙巷内两冒看粘半比舟乐橡资灌劫捕栽幻侄茧虫费旅英莫欲诵碰旋渣孕黑销艘垄筐征迁控统喝挺叠稠壮咸僚浩立踩吩惊灯取格响即排涌咽徒蜻荣蛮介蓄宗忆列年台校贺绸鞠炼砌蒜冻乖躺犬览娘忧酱抢桂毕臣吨慨起另歇竖懒桶射搜傻塑精福语布美够标怎婆搁议木习麻压缺甚蜓昂磨清王邮屠钻货眯藏理湾负甜拣原誉";
		Consumer<String> consumer = (f) -> {
			final String pinyin = ChineseCharacter.convertToPinyin(Chinese);
    	final String[] tokens = ChineseCharacter.parsePinyin(pinyin, Chinese.length());
    	HashMap<String,String> content = new HashMap<String, String>();
    	for(int i = 0; i < Chinese.length(); i++) {
    		while(!content.getOrDefault(tokens[i], "0").equals("0")){
                tokens[i] += " ";
            }
    		content.put(tokens[i], String.valueOf(Chinese.charAt(i)));
    	}
        //MSDStringSort
        final MSDStringBPMFSort msdBPMFStringSort = new MSDStringBPMFSort();
        msdBPMFStringSort.sort(tokens);
		};
        Benchmark<String> benchMark = new Benchmark<String>("result",consumer);
		double time = benchMark.run(Chinese, 1000);
		System.out.println("Sort 320 Chinese characters: "+time+" ms");
    }
	
	@Test
    public void testConvertToPinyinTime6() {
		final String Chinese = "稠握像抱庙莫举察鼓柳枣渔狮博蔬紫绪当岂仙晓饰副鄙舌戴酷各拆盏拢介蛇久洪江验愤欺诵仓化村挪赌障召为糟冒绵泄民乳蜡鲁邀导巧棉援眯喷岩溉切滑乌直宏吹泡剃惜龄蛛箱旦湿吼亏洗森击弓码松芒款圣镇脏丁恼李匆男芳九埋鱼漂尤防瓜晚烈数卷逐慰块微迈致机浮展骨司蹲钩郎富隔惧辅商室饭被释他俭弯蚀另泻剧星班帅幼汗迫丑悔幸啊笨货斑哑眉弊假仇场消傲改杜拘妈杨卖测京殿童滴烤猪破封掠眼权肤确倒显闯简轿椒损戚纽跳写良探浓爹浇画镰胸贿纪聚鸟洁些痒食渴罢夜丰猜依杆惩赔妥从局邮环叨祸艺减榨旗几猛覆根至捞狭闲暴乃瞎酱捡芦住疆锤俗贷灿播射啄厉呼芽越悼盟耻乙纳坝泛促灰躬塞滔暑逮右发档毯胀品跃猴终临笛怀锦估磨匀抖抽余灾代软针猎那凯记蛋恋匪锹失加功助吞扩丙拍考死亩螺工帆林镜奥阴她晋伤隐植棋群痛无单姜歇蠢姿船稻撤宪蚕怨琴押居担忙替次秆版井钱误蔑君启族仍酸寺爆域捎液歼燕挥受成素伍续阁家陵凡谅津搁条俊座倚职于络最咬悲涝督武奏遭玻呜补愧主辉生掏徐这傅馒姑弦冲骤唉奸四寇再拣恭渐歌昂售敏炸喇候孤芝两有鹊潜照倘边袋浙蒜华羡价稿敬宗雹萌巷虹姨牌拔了栏幕刊须寨沈示兆畏混士夸干插急裕移朗痕兰物踢神贱衰僵醉搏掉除峰联牵扎念庄力段咸溪吵得起也苗穿庭霉经河阳心请滚楼悦负器漏涂谦授岸澡赵咱甘筹揪填绿尺煎宾棵袭屯揉赚润样帽雨视限秒反钟挖清片饲摆坐劈槽爽称祖窝现踪孝月截昆梅五思回传帖链怎壶裳隶世望竿勇况逃约炊垃中蹈银寸占赠和股诗呈迎瘦堪伸名才筛盈朝头尚果慎国识壳深叼炼肃佳险筐树茧六蜻且帝奴旁距页矿狠鸣蝴纲道好装郊阔而程孩衣统巴凝撞钉乱拌忍驰秘";
		Consumer<String> consumer = (f) -> {
			final String pinyin = ChineseCharacter.convertToPinyin(Chinese);
    	final String[] tokens = ChineseCharacter.parsePinyin(pinyin, Chinese.length());
    	HashMap<String,String> content = new HashMap<String, String>();
    	for(int i = 0; i < Chinese.length(); i++) {
    		while(!content.getOrDefault(tokens[i], "0").equals("0")){
                tokens[i] += " ";
            }
    		content.put(tokens[i], String.valueOf(Chinese.charAt(i)));
    	}
        //MSDStringSort
        final MSDStringBPMFSort msdBPMFStringSort = new MSDStringBPMFSort();
        msdBPMFStringSort.sort(tokens);
		};
        Benchmark<String> benchMark = new Benchmark<String>("result",consumer);
		double time = benchMark.run(Chinese, 1000);
		System.out.println("Sort 640 Chinese characters: "+time+" ms");
    }
	
	@Test
    public void testConvertToPinyin1() {
		final String Chinese = "拜办拜办我";
    	final String pinyin = ChineseCharacter.convertToPinyin(Chinese);
    	final String[] tokens = ChineseCharacter.parsePinyin(pinyin, Chinese.length());
    	HashMap<String,String> content = new HashMap<String, String>();
    	for(int i = 0; i < Chinese.length(); i++) {
    		while(!content.getOrDefault(tokens[i], "0").equals("0")){
                tokens[i] += " ";
            }
    		content.put(tokens[i], String.valueOf(Chinese.charAt(i)));
    	}
        //MSDStringSort
        final MSDStringBPMFSort msdBPMFStringSort = new MSDStringBPMFSort();
        msdBPMFStringSort.sort(tokens);
        List<String> list = new ArrayList<>();
        for(String s:tokens){
            list.add(content.get(s));
            System.out.println(content.get(s)+" : "+s);
        }
        System.out.println(list);
    }
	
	@Test
    public void testConvertToPinyin2() {
		final String Chinese = "据俄新社援引扎波罗热核电站所在的埃涅尔戈达尔市官员的消息称乌克兰军队日凌晨使用飓风火箭炮对扎波罗热核电站进行了炮击炮击区域涉及乏燃料棒的储存设施区域和辐射情况自动监测站弹片落在了正在运行的发电机组附近距离不超过米";
    	final String pinyin = ChineseCharacter.convertToPinyin(Chinese);
    	final String[] tokens = ChineseCharacter.parsePinyin(pinyin, Chinese.length());
    	HashMap<String,String> content = new HashMap<String, String>();
    	for(int i = 0; i < Chinese.length(); i++) {
    		while(!content.getOrDefault(tokens[i], "0").equals("0")){
                tokens[i] += " ";
            }
    		content.put(tokens[i], String.valueOf(Chinese.charAt(i)));
    	}
        //MSDStringSort
        final MSDStringBPMFSort msdBPMFStringSort = new MSDStringBPMFSort();
        msdBPMFStringSort.sort(tokens);
        List<String> list = new ArrayList<>();
        for(String s:tokens){
            list.add(content.get(s));
            System.out.println(content.get(s)+" : "+s);
        }
        System.out.println(list);
    }
}
