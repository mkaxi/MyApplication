package com.huawei.androidsix;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    private View fragmentView;

    private GridView gridview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentView=inflater.inflate(R.layout.fragment_main, container, false);
        initViewForFindByViewId();
        loadImages();
        gridview.setAdapter(new GridViewAdapter(inflater,MainActivityFragment.this));
        return fragmentView;
    }

    /**
     * find View Id;
     */
    private void initViewForFindByViewId(){
        gridview=(GridView)fragmentView.findViewById(R.id.gridview);
    }

    private class GridViewAdapter extends BaseAdapter{

        private LayoutInflater layoutInflater;
        private Fragment fragment;

        public  GridViewAdapter(LayoutInflater layoutInflater,Fragment fragment){
            this.layoutInflater=layoutInflater;
            this.fragment=fragment;
        }


        @Override
        public int getCount() {
            return imageList.size();
        }

        @Override
        public Object getItem(int position) {
            return imageList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView==null){
                viewHolder=new ViewHolder();
                convertView=layoutInflater.inflate(R.layout.gridview_layout,null);
                viewHolder.imageView=(ImageView)convertView.findViewById(R.id.imageView);
                convertView.setTag(viewHolder);
            }else {
                viewHolder=(ViewHolder)convertView.getTag();
            }

            Glide.with(fragment).load(getItem(position).toString()).into(viewHolder.imageView);

            return convertView;
        }

        private  class  ViewHolder{

            ImageView imageView;

        }


    }


    private List<String> imageList=new ArrayList<>();


    private void loadImages(){

        imageList.add("http://pic19.nipic.com/20120310/8061225_093309101000_2.jpg");
        imageList.add("http://hiphotos.baidu.com/%B9%CF%81%40%81%40/pic/item/a64ae9f8dbe84645242df241.jpeg");
        imageList.add("http://pic3.nipic.com/20090519/2390580_090051082_2.jpg");
        imageList.add("http://img0.imgtn.bdimg.com/it/u=1785667937,1459113298&fm=21&gp=0.jpg");
        imageList.add("http://www.pp3.cn/uploads/allimg/111111/0943302045-4.jpg");
        imageList.add("http://www.jxitsy.com/uploads/130426/2-1304261A4402R.jpg");
        imageList.add("http://img4.imgtn.bdimg.com/it/u=2709759312,2740143763&fm=21&gp=0.jpg");
        imageList.add("http://img2.imgtn.bdimg.com/it/u=2558102655,3896544023&fm=21&gp=0.jpg");
        imageList.add("http://img0.imgtn.bdimg.com/it/u=1467368021,1766653209&fm=21&gp=0.jpg");
        imageList.add("http://image.tianjimedia.com/uploadImages/2013/164/GP043Q56QS4F_2560x1600.jpg");
        imageList.add("http://image71.360doc.com/DownloadImg/2014/03/1312/39857684_21.jpg");
        imageList.add("http://img0.imgtn.bdimg.com/it/u=3965437030,1654885971&fm=21&gp=0.jpg");
        imageList.add("http://www.bz55.com/uploads/allimg/150316/140-150316105543.jpg");
        imageList.add("http://www.bz55.com/uploads/allimg/150313/140-150313113942.jpg");
        imageList.add("http://d.3987.com/fengj_141105/007.jpg");
        imageList.add("http://img0.imgtn.bdimg.com/it/u=3435275813,3254610188&fm=21&gp=0.jpg");
        imageList.add("http://pic1.win4000.com/wallpaper/5/540556f306f26.jpg");
        imageList.add("http://img1.imgtn.bdimg.com/it/u=3571671602,1445681305&fm=21&gp=0.jpg");
        imageList.add("http://img3.imgtn.bdimg.com/it/u=2134346240,3031346659&fm=21&gp=0.jpg");
        imageList.add("http://bbs.crsky.com/1236983883/Mon_1407/25_184488_fa75ce9a01cd903.jpg");
        imageList.add("http://www.deskcar.com/desktop/fengjing/2013423162531/4.jpg");
        imageList.add("http://d.3987.com/haijing_140827/007.jpg");
        imageList.add("http://www.pp3.cn/uploads/allimg/111112/09344L952-7.jpg");
        imageList.add("http://img15.3lian.com/2015/a1/13/d/16.jpg");
        imageList.add("http://imgsrc.baidu.com/forum/pic/item/8ad4b31c8701a18baddecdf69e2f07082838fe56.jpg");
        imageList.add("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1301/23/c0/17656011_1358928951509.jpg");
        imageList.add("http://www.33.la/uploads/zmbz/weimei/wmlomofghh_61902.jpg");
        imageList.add("http://www.bizhiwa.com/uploads/allimg/2012-02/15195556-1-1LB9.jpg");
        imageList.add("http://img0.imgtn.bdimg.com/it/u=1287390653,2661912467&fm=21&gp=0.jpg");
        imageList.add("http://www.bz55.com/uploads/allimg/130812/1-130Q2110336.jpg");
        imageList.add("http://www.bz55.com/uploads/allimg/130625/1-130625103Q8.jpg");
        imageList.add("http://www.bz55.com/uploads/allimg/130306/1-130306092011-50.jpg");
        imageList.add("http://www.bz55.com/uploads/allimg/150710/139-150G0105016.jpg");
        imageList.add("http://pic3.bbzhi.com/fengjingbizhi/guowaifengjingsheyingyishukuanping/show_fengjingou_290556_10.jpg");
        imageList.add("http://www.popoho.com/uploads/allimg/120729/2000261G6-0.jpg");
        imageList.add("http://xiaomila.cn/uploadfile/2014/1202/20141202081732235.jpg");
        imageList.add("http://pic1.win4000.com/wallpaper/6/5477d9870535e.jpg");
        imageList.add("http://image.tianjimedia.com/uploadImages/2012/090/VAX5H2HR9E9F.jpg");
        imageList.add("http://att.x2.hiapk.com/forum/201305/14/13410506pm9rrrk9srrm06.jpg");
        imageList.add("http://bizhi.33lc.com/uploadfile/2014/0402/20140402102054185.jpg");
        imageList.add("http://img5.duitang.com/uploads/item/201306/30/20130630143352_Y3Bxf.jpeg");
        imageList.add("http://www.33.la/uploads/20141114bztp/1345.jpg");
        imageList.add("http://img.article.pchome.net/01/61/06/98/pic_lib/wm/12.jpg");
        imageList.add("http://www.pp3.cn/uploads/1212qxn/796.jpg");
        imageList.add("http://www.bz55.com/uploads/allimg/130228/1-13022PZ649.jpg");
        imageList.add("http://image.tianjimedia.com/uploadImages/2013/100/6WDBH207OELO_2560x1600.jpg");
        imageList.add("http://d.3987.com/huaduo2_140715/001.jpg");
        imageList.add("http://img2.imgtn.bdimg.com/it/u=4099825781,3709523277&fm=21&gp=0.jpg");

    }




}


















