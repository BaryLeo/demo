package design.chain;

public class ChainMain {

    public static void main(String[] args){
        String s = "aaabbbbb,<haha>,丢雷楼某";
        Msg msg = new Msg();
        msg.setMsg(s);
        //新建过滤连
        FilterChain filterChain = new FilterChain();
        //过滤有安全威胁得
        filterChain.addFilter(new SecurityFilter()).addFilter(new WordsFilter());
        //过滤粗鄙之语
        filterChain.doFilter(msg);
        System.out.println(msg.getMsg());
        //拼接过滤链
        FilterChain filterChain1 = new FilterChain();
        filterChain1.addFilter(new LogoFilter());
        filterChain.addFilter(filterChain1);
        msg.setMsg(s);
        filterChain.doFilter(msg);
        System.out.println(msg.getMsg());
    }
}
