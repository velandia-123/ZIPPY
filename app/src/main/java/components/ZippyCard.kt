package components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.*

@Composable
fun ZippyCard(

    titulo: String,

    descripcion: String,

    onClick: () -> Unit = {}

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },

        shape = ZippyShapes.Medium,

        colors = CardDefaults.cardColors(
            containerColor = ZippySurface
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )

    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = titulo,
                style = ZippyTypography.Subtitle,
                color = ZippyText
            )

            Text(
                text = descripcion,
                style = ZippyTypography.Body,
                color = ZippyTextSecondary
            )

        }

    }

}