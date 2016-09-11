package id.sch.smktelkom_mlg.tugas01.xirpl224.formpengembalianbukupustel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etBuku, etTelat;
    Button bOk;
    TextView tvNama, tvStatus, tvJudul, tvJurusan, tvTanggapan, tvDenda, tvTelat;
    RadioGroup rgStts;
    RadioButton rbTw, rbTb;
    Spinner spJurusan;
    CheckBox cbM, cbB, cbMb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etBuku = (EditText) findViewById(R.id.editTextBuku);
        bOk = (Button) findViewById(R.id.buttonOk);
        tvNama = (TextView) findViewById(R.id.textViewNama);
        tvJudul = (TextView) findViewById(R.id.textViewJudul);
        tvStatus = (TextView) findViewById(R.id.textViewStatus);
        tvJurusan = (TextView) findViewById(R.id.textViewJurusan);
        tvTanggapan = (TextView) findViewById(R.id.textViewTanggapan);
        rbTw = (RadioButton) findViewById(R.id.radioButtonTw);
        rbTb = (RadioButton) findViewById(R.id.radioButtonTb);
        spJurusan = (Spinner) findViewById(R.id.spinnerJurusan);
        cbM = (CheckBox) findViewById(R.id.checkBoxM);
        cbB = (CheckBox) findViewById(R.id.CheckBoxB);
        cbMb = (CheckBox) findViewById(R.id.checkBoxMb);
        rgStts = (RadioGroup) findViewById(R.id.radioGroupStatus);
        tvDenda = (TextView) findViewById(R.id.textViewDenda);
        tvTelat = (TextView) findViewById(R.id.textViewTelat);
        etTelat = (EditText) findViewById(R.id.editTextTelat);

        rgStts.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                if (i == R.id.radioButtonTw) {
                    findViewById(R.id.editTextTelat).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.editTextTelat).setVisibility(View.VISIBLE);
                }
            }
        });


        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
                doClick();
                doCoba();
            }
        });

    }

    private void doCoba() {
        String hasil = "Tanggapan Anda : ";
        int startlen = hasil.length();
        if (cbM.isChecked()) hasil += cbM.getText() + "\n";
        if (cbB.isChecked()) hasil += cbB.getText() + "\n";
        if (cbMb.isChecked()) hasil += cbMb.getText() + "\n";

        if (hasil.length() == startlen) hasil += "Tidak Ada Tanggapan";

        tvTanggapan.setText(hasil);
    }

    private void doClick() {
        String status = null;

        if (rbTb.isChecked()) {
            status = rbTb.getText().toString();
        } else if (rbTw.isChecked()) {
            status = rbTw.getText().toString();
        }

        if (status == null) {
            tvStatus.setText("Belum Memilih Status");
        } else {
            tvStatus.setText("Status Anda : " + status);
        }
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String buku = etBuku.getText().toString();
            String telat = etTelat.getText().toString();
            int denda = Integer.parseInt(etTelat.getText().toString());
            int d = 500 * denda;

            tvNama.setText("Nama : " + nama);
            tvJudul.setText("Judul Buku : " + buku);
            tvJurusan.setText("Kelas : " + spJurusan.getSelectedItem().toString());
            tvTelat.setText("Telat : " + telat);
            tvDenda.setText("Denda : Rp" + d);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String buku = etBuku.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum diisi");
            valid = false;
        } else if (buku.isEmpty()) {
            etBuku.setError(" Judul Buku Belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
        }

        return valid;
    }
}
