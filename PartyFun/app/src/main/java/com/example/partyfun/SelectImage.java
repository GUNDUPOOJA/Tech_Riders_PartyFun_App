package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class SelectImage extends AppCompatActivity {
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16, img17, img18;
    private final int CODE_MULTIPLE_IMG_GALLERY = 18;

    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);
        init();


        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "images"), CODE_MULTIPLE_IMG_GALLERY);
            }
        });

    }

    public void onImage(View v) {

        Intent intent_special = new Intent(this, SpecialOne.class);
        startActivity(intent_special);


        /*Intent image = new Intent(this, FourthActivity.class);
        startActivity(image);*/
    }

    private void init() {

        this.img1 = findViewById(R.id.imageView1);
        this.img2 = findViewById(R.id.imageView2);
       this.img3 = findViewById(R.id.imageView3);
        this.img4 = findViewById(R.id.imageView4);
        this.img5 = findViewById(R.id.imageView5);
        this.img6 = findViewById(R.id.imageView6);
//        this.img7 = findViewById(R.id.imageView7);
//        this.img8 = findViewById(R.id.imageView8);
//        this.img9 = findViewById(R.id.imageView9);
//        this.img10 = findViewById(R.id.imageView10);
//        this.img11 = findViewById(R.id.imageView11);
//        this.img12 = findViewById(R.id.imageView12);
//        this.img13 = findViewById(R.id.imageView13);
//        this.img14 = findViewById(R.id.imageView14);
//        this.img15 = findViewById(R.id.imageView15);
//        this.img16 = findViewById(R.id.imageView16);
//        this.img17 = findViewById(R.id.imageView17);
//        this.img18 = findViewById(R.id.imageView18);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODE_MULTIPLE_IMG_GALLERY && resultCode == RESULT_OK) {


            ClipData clipdata = data.getClipData();

            if (clipdata != null) {
                img1.setImageURI(clipdata.getItemAt(0).getUri());
                img2.setImageURI(clipdata.getItemAt(1).getUri());
                img3.setImageURI(clipdata.getItemAt(2).getUri());
                img4.setImageURI(clipdata.getItemAt(3).getUri());
                img5.setImageURI(clipdata.getItemAt(4).getUri());
                img6.setImageURI(clipdata.getItemAt(5).getUri());

                for (int i = 0; i < clipdata.getItemCount(); i++) {
                    ClipData.Item item = clipdata.getItemAt(i);
                    Uri uri = item.getUri();
                    Log.d("onActivityResult: ", uri.toString());
                }
            }


//
//    public void onBrowse(View v){
//        imageView = findViewById(R.id.imageView);
//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                openGallery();
//            }
//        });
//    }
//    private void openGallery(){
//        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
//        startActivityForResult(gallery, PICK_IMAGE);
//    }
//
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
//            imageUri = data.getData();
//            imageView.setImageURI(imageUri);
//        }
//
//    }
        }
    }
}
