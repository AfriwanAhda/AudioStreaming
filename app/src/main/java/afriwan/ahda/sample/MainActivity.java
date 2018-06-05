//      بِسْمِ اللَّهِ الرَّحْمَٰنِ الرَّحِيمِ

package afriwan.ahda.sample;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import afriwan.ahda.AudioStreaming;

public class MainActivity extends AppCompatActivity {

    private AudioStreaming audioStreamingCustomFont;
    String url = "http://203.24.76.112:8000/stereo";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioStreamingCustomFont = (AudioStreaming) findViewById(R.id.playCustomFonts);
        Typeface iconFont = Typeface.createFromAsset(getAssets(), "audio-player-view-font-custom.ttf");
        audioStreamingCustomFont.setTypeface(iconFont);
        audioStreamingCustomFont.withUrl(url);
    }

    @Override
    protected void onDestroy() {
        audioStreamingCustomFont.destroy();
        super.onDestroy();
    }
}
