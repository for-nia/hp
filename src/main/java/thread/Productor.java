package thread;

/**
 * Created by Fornia.fu on 2016/4/25.
 */
public class Productor extends Thread
{
    private Goods goods;
    private int num;
    public Productor(Goods goods){
        this.goods=goods;
    }
    public void run()
    {
        goods.product(num);
    }

    public int getNum()
    {
        return num;
    }

    public void setNum(int num)
    {
        this.num = num;
    }
}
