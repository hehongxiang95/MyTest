package com.example.mytest.waterfall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mytest.R;
import com.example.mytest.waterfall.view.ScaleImageView;
import com.example.mytest.waterfall.view.StaggeredGridView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.Map;

public class WaterFallActivity extends AppCompatActivity {

    private static final String TAG = "WaterFallActivity";
    private StaggeredGridView gridView;
    private ArrayList<Map<String, Object>> list;
    private Map<String, Object> map;
    String[] imageUrls = new String[] {
            "http://img.hb.aicdn.com/b56c301cda647bf8c21e7cf155973081fe801e5220e4d-gZ3zst_fw658",
            "http://img.hb.aicdn.com/7faadf681909a79a6090169063d66b7a2c921e30109663-K58EIk_fw658",
            "http://img.hb.aicdn.com/ccbd64bb5195075e4840143b8f6df120c10fed5d340b6-3h1RVU_fw658",
            "http://img.hb.aicdn.com/7d0747084e14b8893323ddad9e70bf9f462662143dae1-C8X1Xp_fw658",
            "http://img.hb.aicdn.com/9d3eb0c7a79cc8afd67f6ed35ccec779ca1b5d6d3d766-jWNspO_fw658",
            "http://img.hb.aicdn.com/93a8b71de894a783c2acb71c582cdc6a065bf3714c49c-QtW50I_fw658",
            "http://img.hb.aicdn.com/f9fb44ad7bc4f6309fd4a7b123424c00b2a2eaaf862f-uIZv0G_fw658",
            "http://img.hb.aicdn.com/7b96ac0b5d3c44cb09e63320337ce8705bf833ef1c5b1-BZVkOc_fw658",
            "http://img.hb.aicdn.com/1a030d7f4417d8577ae3fcf9af422734d4e2584367d523-XPLNq5_fw658",
            "http://img.hb.aicdn.com/9b0bb2be35fe0a7946b9871fa5a0c94ddbbea0733224ab-jTneBJ_fw658",
            "http://img.hb.aicdn.com/a45e3f18662b3fff4d3f9f0e1c9dcfd1e310e2c31aa6a-PpO93z_fw658",
            "http://img.hb.aicdn.com/db8f29f22e9e6cf6e624b5e5e46d0418460d87a31eee7-ssMYlk_fw658",
            "http://img.hb.aicdn.com/cade9618de63012c099b2ff443f26631e72d4c3829a3e-R6rQ6C_fw658",
            "http://img.hb.aicdn.com/57e5594abcc15ec2b45065c8311de3173cfe89871cfe7-PWpWWP_fw658",
            "http://img.hb.aicdn.com/22c601e315110264caa550075fdfa0b6e846848012dd50-V234w0_fw658",
            "http://img.hb.aicdn.com/0ed87bbf5f08c0f746eaa6cfcee0ed661d3d92a230801-8ksDUt_fw658"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_fall);

        gridView = (StaggeredGridView) findViewById(R.id.gridview);
        gridView.setItemMargin(10);
        gridView.setPadding(10, 0, 10, 0);

        ImageAdapter adapter=new ImageAdapter();
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    class ImageAdapter extends BaseAdapter {


        @Override
        public View getView(final int position, View convertView,
                            ViewGroup parent) {
            View view = convertView;
            final ViewHolder holder;
            if (convertView == null) {
                LayoutInflater layoutInflator = LayoutInflater.from(WaterFallActivity.this);
                view = layoutInflator.inflate(R.layout.list_item_staggered,
                        null);
                holder = new ViewHolder();
                holder.image = (ScaleImageView) view.findViewById(R.id.imageView1);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            ImageLoader.getInstance().displayImage(imageUrls[position], holder.image );
            /*Glide.with(WaterFallActivity.this).load(imageUrls[position])
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontTransform()
                    .placeholder(R.drawable.ic_launcher)
                    .into(holder.image);*/

            return view;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return imageUrls.length;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return imageUrls[arg0];
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }
    }
    private static class ViewHolder {
        ScaleImageView image;
    }

}
