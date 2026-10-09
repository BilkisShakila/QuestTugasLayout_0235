package com.example.tugas3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 1. Fungsi Utama Tampilan
@Composable
fun ActivityPertama(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        // Judul Utama
        Text(
            text = stringResource(id = R.string.app_title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = stringResource(id = R.string.app_subtitle),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Card 1: Bilkis Aqilatusshakila (Menggunakan font Cursive/Latin & tanpa nomor telepon)
        ProfileCard(
            name = stringResource(id = R.string.card1_name),
            phone = null,
            location = stringResource(id = R.string.card1_location),
            backgroundColor = colorResource(id = R.color.card_gray),
            logoResId = R.drawable.logo_umy,
            fontFamily = FontFamily.Cursive // Mengubah font menjadi gaya latin/kursif
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Card 2: Maulina Khamidah
        ProfileCard(
            name = stringResource(id = R.string.card2_name),
            phone = stringResource(id = R.string.card2_phone),
            location = stringResource(id = R.string.card2_location),
            backgroundColor = colorResource(id = R.color.card_purple),
            logoResId = R.drawable.logo_umy
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Card 3: Rachel venya
        ProfileCard(
            name = stringResource(id = R.string.card3_name),
            phone = stringResource(id = R.string.card3_phone),
            location = stringResource(id = R.string.card3_location),
            backgroundColor = colorResource(id = R.color.card_blue),
            logoResId = R.drawable.logo_umy
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Card 4: Azizah Nur Khamid
        ProfileCard(
            name = stringResource(id = R.string.card4_name),
            phone = stringResource(id = R.string.card4_phone),
            location = stringResource(id = R.string.card4_location),
            backgroundColor = colorResource(id = R.color.card_green),
            logoResId = R.drawable.logo_umy
        )

        // Mendorong teks copyright ke bawah layar
        Spacer(modifier = Modifier.weight(1f))

        // Teks Copyright
        Text(
            text = stringResource(id = R.string.copyright_text),
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

// 2. Fungsi Reusable Card dengan tambahan parameter fontFamily
@Composable
fun ProfileCard(
    name: String,
    phone: String?,
    location: String,
    backgroundColor: Color,
    logoResId: Int,
    fontFamily: FontFamily = FontFamily.Default // Default-nya font biasa
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Logo Kiri
            Image(
                painter = painterResource(id = logoResId),
                contentDescription = "Logo UMY",
                modifier = Modifier.size(45.dp)
            )

            // Teks Informasi (Nama, Telepon, Lokasi)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp)
            ) {
                Text(
                    text = name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp, // Sedikit diperbesar agar gaya latinnya makin terlihat jelas
                    fontFamily = fontFamily // Menerapkan font latin/kursif
                )
                if (!phone.isNullOrEmpty()) {
                    Text(
                        text = phone,
                        color = Color.White,
                        fontSize = 13.sp
                    )
                }
                Text(
                    text = location,
                    color = Color.White,
                    fontSize = 13.sp,
                    fontFamily = fontFamily // Menerapkan font yang sama ke teks lokasi
                )
            }

            // Logo Kanan
            Image(
                painter = painterResource(id = logoResId),
                contentDescription = "Logo UMY",
                modifier = Modifier.size(45.dp)
            )
        }
    }
}