package mad155.kmathes.mad155module7imageorganizer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer[] celebrityPic = {
            R.drawable.cate1,
            R.drawable.jennifer1,
            R.drawable.kate1,
            R.drawable.orlando1,
            R.drawable.tom1,
            R.drawable.will1
            };

    String[] celebrityName = {
            "Cate Blanchett",
            "Jennifer Lawerence",
            "Kate Winslet",
            "Orlando Bloom",
            "Tom Hanks",
            "Will Smith"
            };

    ImageView pic;

    Button btnShowMovies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //.. set the title on the action bar for this activity and override title in manifest
        setTitle(R.string.txtTitle);

        //.. to get rid of action bar for this activity (because I needed more room on screen
        //try
        //{
        //    this.getSupportActionBar().hide();
        //}
        //catch (NullPointerException e){}
        //setContentView(R.layout.activity_main);


        GridView grid1 = (GridView) findViewById(R.id.gridView1);
        final ImageView pic = (ImageView) findViewById(R.id.imgLarge);
        btnShowMovies = (Button) findViewById(R.id.btn1);
        final TextView celebNameTV = (TextView) findViewById(R.id.txtName);

        btnShowMovies.setOnClickListener(bShowMovies);

        grid1.setAdapter(new ImageAdapter1(this));

        grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(),"Selected Celebrity: " + (position + 1),
                        Toast.LENGTH_SHORT).show();

                pic.setImageResource(celebrityPic[position]);
                celebNameTV.setText(celebrityName[position]);
            }
        });


    }

    Button.OnClickListener bShowMovies = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {

            //set up what to pass and perform intent

        }
    };

    public class ImageAdapter1 extends BaseAdapter {

        private Context context;

        public ImageAdapter1(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return celebrityPic.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(celebrityPic[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,375));
            return pic;
        }
    }


}
