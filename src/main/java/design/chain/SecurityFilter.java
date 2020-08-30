package design.chain;

public class SecurityFilter implements Filter {
    @Override
    public void doFilter(Msg msg) {
        String s= msg.getMsg();
        s  = s.replace('<',' ');
        s = s.replace('>',' ');
        msg.setMsg(s);
    }
}
