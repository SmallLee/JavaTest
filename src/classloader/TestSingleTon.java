package classloader;

public class TestSingleTon {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getSingleTon();
        System.out.println(singleTon.count1);//1
        System.out.println(singleTon.count2);//0
    }
}

/*
* 结果分析
* 1.先执行TestSingleTon的第一句SingleTon singleTon = SingleTon.getSingleTon();
* 因为此时SingleTon还没有加载和连接，所以先加载和连接
* 2.连接-准备阶段，为静态变量初始化，singleTon=null,count1=0,count2=0
* 3.加载和连接完毕，进行初始化工作，注意这个时候还没有调用SingleTon.getSingleTon();
* 4.初始化工作是从上到下依次执行，先执行SingleTon singleTon = new SingleTon()
* 此时执行构造函数，count1=1,count2=1
* 5.接下来轮到了count1,我们并没有对它进行初始化，所以它就没办法进行初始化工作了，此时count1还是1
* 6.count2我们初始化为0
* 7.初始化完毕我们调用了SingleTon.getSingleTon()，此时返回的singleTon已经初始化过了，所以
* 结果是1和0
*
* */