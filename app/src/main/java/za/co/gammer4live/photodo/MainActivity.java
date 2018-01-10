package za.co.gammer4live.photodo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button capturedImageButton;
    ImageView imageHolder;
    Intent intent;

    public static final int RequestPermissionCode = 1;
    private final int requestCode = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageHolder = (ImageView)findViewById(R.id.imageView);

    }



    public void startCamera(android.view.View view) {

        Toast.makeText(this, "You clicked the button", Toast.LENGTH_SHORT).show();

        Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(photoCaptureIntent, requestCode);

    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(this.requestCode == requestCode && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            imageHolder.setImageBitmap(bitmap);
        }
    }




    public void captureImage(android.view.View view) {



    }

    public void copyToClipboard(android.view.View view) {



    }


    public void speakText(android.view.View view) {



    }
    public void shareText(android.view.View view) {



    }
    public void saveToNote(android.view.View view) {



    }

    public void loadAirtime(android.view.View view) {



    }


}
