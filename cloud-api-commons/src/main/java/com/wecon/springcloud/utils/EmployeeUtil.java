package com.wecon.springcloud.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author zhl
 * @create 2021/1/14 11:37
 * @description 员工类随机生成测试数据
 */
public class EmployeeUtil {

    private static String sex = null;
    /**
     * 姓名和性别
     */
    private static String[] sexAndName = new String[2];
    /**
     * 随机生成姓名男女比例指数临界点
     */
    private static final int POINT = 2;
    /**
     * 随机产生名字
     * @return
     */
    public static String[] getName() {
        Random random = new Random();
        String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",
                "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",
                "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",
                "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",
                "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",
                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季"};
        String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶" +
                "怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
        String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心" +
                "邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
        int index = random.nextInt(Surname.length - 1);
        //获得一个随机的姓氏
        String name = Surname[index];
        //可以根据这个数设置产生的男女比例
        int i = random.nextInt(3);
        if(i == POINT){
            sex = "女";
            randomSexAndName(random, girl, name);
        }
        else{
            sex = "男";
            randomSexAndName(random, boy, name);
        }
        return sexAndName;
    }

    /**
     * 随机生成组合性别和年龄（公共代码抽取）
     * @param random
     * @param boy
     * @param name
     */
    private static void randomSexAndName(Random random, String boy, String name) {
        int j = random.nextInt(boy.length() - 2);
        if (j % POINT == 0) {
            name = name + boy.substring(j, j + 2);
        } else {
            name = name + boy.substring(j, j + 1);
        }
        sexAndName[0] = name;
        sexAndName[1] = sex;
    }

    /**
     * 功能：随机产生年龄
     *
     * @return
     */
    public static int getAge() {
        return new Random().nextInt(82) + 18;
    }

    /**
     * 功能：随机产生薪水
     *
     * @return
     */
    public static long getSalary() {
        return new Random().nextInt(8200) + 1800;
    }

    /**
     * 功能：随机产生日期
     * @return
     */
    public static Date randomDate(String beginDate, String endDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            // 构造开始日期
            Date start = format.parse(beginDate);
            // 构造结束日期
            Date end = format.parse(endDate);
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if (start.getTime() >= end.getTime()) {
                return null;
            }
            long date = random(start.getTime(), end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
     * @param begin
     * @param end
     * @return
     */
    private static long random(long begin, long end) {
        long rtn = (long) (begin +  (Math.random() * (end - begin)));

        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    /**
     * 随机产生邮箱
     * @return
     */
    public static String getEmail() {
        return new Random().nextInt(10000000) + 19999999 +"@qq.com";
    }

    /**
     * 随机产生电话号码
     * @return
     */
    public static String getPhone_number() {
        return new Random().nextInt(1800000000) + 189999999 +"";
    }


    /**
     * 随机产生电话号码和职位编号
     * @return
     */
    public static Long getDepartmentAndJob_id() {
        Long [] arr = {10L,20L,30L,40L,50L,60L,70L,80L,90L,100L,
                110L,120L,130L,140L,150L,160L,170L,180L,190L,200L,
                210L,220L,220L,230L,240L,250L,260L,270L};
        int index=(int)(Math.random()*arr.length);
        return arr[index];
    }

    /**
     * 随机管理员id
     * @return
     */
    public static Long getManager_id() {
        return (long)new Random().nextInt(10000) + 19999;
    }


}
