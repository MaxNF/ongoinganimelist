package ru.netfantazii.ongoinganimelist.motion

import android.graphics.Path
import android.transition.PathMotion

class LinearPathMotion : PathMotion() {
    override fun getPath(startX: Float, startY: Float, endX: Float, endY: Float): Path {
        val path = Path()
        path.moveTo(startX, startY)
        path.lineTo(endX, endY)
        return path
    }
}