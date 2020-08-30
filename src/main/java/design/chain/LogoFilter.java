package design.chain;

public class LogoFilter implements Filter {
    @Override
    public void doFilter(Msg msg) {
        String s= msg.getMsg();
        s = s+" logo";
        msg.setMsg(s);
    }
}
