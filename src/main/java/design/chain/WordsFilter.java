package design.chain;

public class WordsFilter implements Filter {
    @Override
    public void doFilter(Msg msg) {
        String s= msg.getMsg();
        s  = s.replaceAll("丢雷楼某" ,"**");
        msg.setMsg(s);
    }
}
