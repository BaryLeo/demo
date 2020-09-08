package design.decorator;

public class DMain {
    public static void main(String[] args){
        NaiCha naiCha = new NaiCha();
        naiCha.show();
        //我想要波霸奶茶
        BoBaNaiDecorator boBaNaiCha = new BoBaNaiDecorator(naiCha);
        boBaNaiCha.show();
        //我想要波霸果冻奶茶
        GuoDonDecorator guoDonDecorator = new GuoDonDecorator(boBaNaiCha);
        guoDonDecorator.show();
    }
}
