import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VideogameAsset
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

// 1. Definición de la Data Class
data class Game(
    val title: String,
    val platform: String,
    val imageUrl: String // Representa la ruta, URL o ID del recurso de la imagen
)

// 2. Creación de la lista de 10 juegos
val gameList = listOf(
    Game("League of Legends", "PC", "url_imagen_lol"),
    Game("Fortnite", "Multiplataforma", "url_imagen_fortnite"),
    Game("Halo Infinite", "Xbox Series S", "url_imagen_halo"),
    Game("The Legend of Zelda: Tears of the Kingdom", "Nintendo Switch", "url_imagen_zelda"),
    Game("God of War Ragnarök", "PlayStation 5", "url_imagen_gow"),
    Game("Minecraft", "Multiplataforma", "url_imagen_minecraft"),
    Game("Cyberpunk 2077", "PC / Consolas", "url_imagen_cyberpunk"),
    Game("Elden Ring", "PC / Consolas", "url_imagen_elden"),
    Game("Super Mario Odyssey", "Nintendo Switch", "url_imagen_mario"),
    Game("Red Dead Redemption 2", "Multiplataforma", "url_imagen_rdr2")
)

// 3 y 4. Uso de LazyColumn y diseño con MaterialTheme
@Composable
fun GameListScreen() {
    // LazyColumn para renderizar la lista de forma eficiente
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(gameList) { game ->
            GameCard(game = game)
        }
    }
}

@Composable
fun GameCard(game: Game) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        // Personalización de la forma (Shape) con un diseño asimétrico elegante
        shape = RoundedCornerShape(topStart = 24.dp, bottomEnd = 24.dp, topEnd = 8.dp, bottomStart = 8.dp),
        // Aplicación del sistema de colores (Colors) de MaterialTheme
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Representación de la imagen (Placeholder para el ejercicio)
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.VideogameAsset,
                    contentDescription = "Imagen de ${game.title}",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(36.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Aplicación de la tipografía (Typography) de MaterialTheme
            Column {
                Text(
                    text = game.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = game.platform,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
