package thread;

/**
 * Created by Fornia.fu on 2016/4/25.
 */
public class Consumer extends Thread
{

    private int num;

    private Goods goods;
    public Consumer(Goods goods)
    {
        this.goods=goods;
    }
    public void run()
    {
        goods.consume(num);
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
