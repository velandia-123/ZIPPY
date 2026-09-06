package components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.ZippySurface

@Composable
fun QuickActionCard(

    titulo: String,
    descripcion: String,
    onClick: () -> Unit

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },

        shape = RoundedCornerShape(20.dp),

        elevation = CardDefaults.cardElevation(6.dp),

        colors = CardDefaults.cardColors(
            containerColor = ZippySurface
        )

    ) {

        Column(

            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),

            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {

            Text(

                text = titulo,

                fontSize = 18.sp,

                fontWeight = FontWeight.Bold,

                color = MaterialTheme.colorScheme.onSurface

            )

            Text(

                text = descripcion,

                style = MaterialTheme.typography.bodyMedium

            )

        }

    }

}