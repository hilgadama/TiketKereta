package id.sch.smktelkom_mlg.tugas01.xiirpl2018.tiketkereta;

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
    EditText etNama, etAlamat, etNoKTP, etTanggal;
    Button bproses;
    TextView tvHasil;
    RadioGroup rgJenis;
    Spinner spDari, spTujuan;
    CheckBox cbBal, cbAnk, cbDew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etNoKTP = (EditText) findViewById(R.id.editTextNoKTP);
        etTanggal = (EditText) findViewById(R.id.editTextTanggal);
        rgJenis = (RadioGroup) findViewById(R.id.RadioGroupJenis);
        bproses = (Button) findViewById(R.id.buttonProses);
        cbBal = (CheckBox) findViewById(R.id.checkBoxBalita);
        cbAnk = (CheckBox) findViewById(R.id.checkBoxAnak);
        cbDew = (CheckBox) findViewById(R.id.checkBoxDewasa);
        spDari = (Spinner) findViewById(R.id.spinnerDari);
        spTujuan = (Spinner) findViewById(R.id.spinnerTujuan);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String alamat = etAlamat.getText().toString();
            String no = etNoKTP.getText().toString();
            String tgl = etTanggal.getText().toString();
            String hasil = null;

            if (rgJenis.getCheckedRadioButtonId() != -1) {
                RadioButton radbut = (RadioButton) findViewById(rgJenis.getCheckedRadioButtonId());
                hasil = radbut.getText().toString();
            }

            if (hasil == null) {
                tvHasil.setText("Anda belum memilih Kelas!");
            } else {
                String dari = spDari.getSelectedItem().toString();
                String tujuan = spTujuan.getSelectedItem().toString();
                String proses = "Nama : " + nama + "\n" +
                        "Alamat : " + alamat + "\n" +
                        "No. KTP : " + no + "\n" +
                        "Tanggal : " + tgl + "\n";
                String proses2 = "Dari : " + dari + "\n" +
                        "Tujuan : " + tujuan + "\n";
                String proses3 = "\n Tiket Untuk : \n";

                if (cbBal.isChecked())
                    proses3 += cbBal.getText() + "\n";
                tvHasil.setText(proses + proses2 + proses3);

                if (cbAnk.isChecked())
                    proses3 += cbAnk.getText() + "\n";
                tvHasil.setText(proses + proses2 + proses3);

                if (cbDew.isChecked())
                    proses3 += cbDew.getText() + "\n";
                tvHasil.setText(proses + proses2 + proses3);


            }
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        String no = etNoKTP.getText().toString();
        String tgl = etTanggal.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama anda belum terisi!");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (no.isEmpty()) {
            etNoKTP.setError("No Identitas harap diisi!");
            valid = false;
        } else if (no.length() > 16) {
            etNoKTP.setError("Nomor identitas maksimal 16 karakter");
            valid = false;
        } else {
            etNoKTP.setError(null);
        }

        if (alamat.isEmpty()) {
            etAlamat.setError("Alamat anda belum terisi!");
            valid = false;
        } else {
            etAlamat.setError(null);
        }

        if (tgl.isEmpty()) {
            etTanggal.setError("Tanggal anda belum terisi");
            valid = false;
        } else {
            etTanggal.setError(null);
        }
        return valid;
    }
}



