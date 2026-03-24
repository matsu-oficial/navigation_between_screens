package matsu_oficial.com.github.navigationbetweenscreens.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PerfilScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    nome: String,
    idade: Int
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFC9C9C9))
            .padding(32.dp)
    ) {
        Text(
            text = "PERFIL - $nome tem $idade anos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFEE3000)
        )
        Button(
            onClick = {navController.navigate("menu")},
            colors = ButtonDefaults.buttonColors(Color(0xFF171717)),
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = "VOLTAR",
                fontSize = 20.sp,
                color = Color(0xFFEE3000)
            )
        }
    }
}