package afriwan.ahda.sample;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import afriwan.ahda.AudioStreaming;

public class MainActivity extends AppCompatActivity {

    String url = "http://203.24.76.112:8000/stereo";
    private View spinner;
    private AudioStreaming audioStreaming, audioStreamingText, audioStreamingCustomFont;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.loading_spinner);

        audioStreaming = (AudioStreaming) findViewById(R.id.play);
        audioStreaming.withUrl(url);
        audioStreaming.setOnAudioPlayerViewListener(new AudioStreaming.OnAudioPlayerViewListener() {
            @Override
            public void onAudioPreparing() {
                Toast.makeText(getBaseContext(), "Audio is loading callback", Toast.LENGTH_SHORT).show();
                spinner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAudioReady() {
                Toast.makeText(getBaseContext(), "Audio is ready callback", Toast.LENGTH_SHORT).show();
                spinner.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAudioFinished() {
                Toast.makeText(getBaseContext(), "Audio finished callback", Toast.LENGTH_SHORT).show();
            }
        });

        audioStreamingText = (AudioStreaming) findViewById(R.id.playText);
        audioStreamingText.withUrl(url);


        audioStreamingCustomFont = (AudioStreaming) findViewById(R.id.playCustomFonts);
        Typeface iconFont = Typeface.createFromAsset(getAssets(), "audio-player-view-font-custom.ttf");
        audioStreamingCustomFont.setTypeface(iconFont);
        audioStreamingCustomFont.withUrl(url);
    }

    @Override
    protected void onDestroy() {
        audioStreaming.destroy();
        audioStreamingText.destroy();
        audioStreamingCustomFont.destroy();
        super.onDestroy();
    }
}
