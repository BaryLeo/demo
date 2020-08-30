package design.chain;

import java.util.ArrayList;
import java.util.List;

//为了能实现链与链的连接，实现该接口
public class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    @Override
    public void doFilter(Msg msg) {
        for (Filter filter:filters){
            filter.doFilter(msg);
        }
    }

    public FilterChain addFilter(Filter filter){
        filters.add(filter);
        return this;
    }
}
