package com.example.netronictesttask.common.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import com.example.netronictesttask.databinding.CustomAnimatedLogoBinding

class CustomAnimatedLogo @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    private var _binding: CustomAnimatedLogoBinding? = null
    private val binding get() = _binding!!

    private var firstCircle: ImageView? = null
    private var secondCircle: ImageView? = null
    private var thirdCircle: ImageView? = null

    private var animationFirst1: SpringAnimation? = null
    private var animationFirst2: SpringAnimation? = null
    private var animationFirst3: SpringAnimation? = null

    private var animationSecond1: SpringAnimation? = null
    private var animationSecond2: SpringAnimation? = null
    private var animationSecond3: SpringAnimation? = null

    private var animationThird1: SpringAnimation? = null
    private var animationThird2: SpringAnimation? = null
    private var animationThird3: SpringAnimation? = null

    init {
        _binding = CustomAnimatedLogoBinding.inflate(
            LayoutInflater.from(context), this, true
        )

        firstCircle = binding.first
        secondCircle = binding.second
        thirdCircle = binding.third

        animationFirst1 = SpringAnimation(firstCircle, DynamicAnimation.TRANSLATION_Y, 0f)

        animationFirst2 = SpringAnimation(firstCircle, DynamicAnimation.TRANSLATION_Y, 0f)
        animationFirst3 = SpringAnimation(firstCircle, DynamicAnimation.TRANSLATION_Y, 0f)

        animationSecond1 = SpringAnimation(secondCircle, DynamicAnimation.TRANSLATION_Y, 0f)
        animationSecond2 = SpringAnimation(secondCircle, DynamicAnimation.TRANSLATION_Y, 0f)
        animationSecond3 = SpringAnimation(secondCircle, DynamicAnimation.TRANSLATION_Y, 0f)

        animationThird1 = SpringAnimation(thirdCircle, DynamicAnimation.TRANSLATION_Y, 0f)
        animationThird2 = SpringAnimation(thirdCircle, DynamicAnimation.TRANSLATION_Y, 0f)
        animationThird3 = SpringAnimation(thirdCircle, DynamicAnimation.TRANSLATION_Y, 0f)

        setSecondAnimation()
        setThirdAnimation()
        setFirstAnimation()
    }

    private fun setFirstAnimation() {
        animationFirst1?.spring?.apply {
            dampingRatio = SpringForce.DAMPING_RATIO_NO_BOUNCY
            stiffness = 400f
        }

        animationFirst2?.spring?.apply {
            dampingRatio = SpringForce.DAMPING_RATIO_NO_BOUNCY
            stiffness = 400f
        }

        animationFirst3?.spring?.apply {
            dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
            stiffness = 400f
        }

        animationFirst1?.addEndListener { _, _, _, _ ->
            animationFirst2?.animateToFinalPosition(200f)
            animationSecond1?.animateToFinalPosition(-200f)
        }

        animationFirst2?.addEndListener { _, _, _, _ ->
            animationFirst3?.animateToFinalPosition(0f)
        }

        animationFirst3?.addEndListener { _, _, _, _ -> }
        animationFirst1?.animateToFinalPosition(-200f)
    }

    private fun setSecondAnimation() {
        animationSecond1?.spring?.apply {
            dampingRatio = SpringForce.DAMPING_RATIO_NO_BOUNCY
            stiffness = 500f
        }

        animationSecond2?.spring?.apply {
            dampingRatio = SpringForce.DAMPING_RATIO_NO_BOUNCY
            stiffness = 500f
        }

        animationSecond3?.spring?.apply {
            dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
            stiffness = 500f
        }

        animationSecond1?.addEndListener { _, _, _, _ ->
            animationSecond2?.animateToFinalPosition(200f)
            animationThird1?.animateToFinalPosition(-200f)
        }

        animationSecond2?.addEndListener { _, _, _, _ ->
            animationSecond3?.animateToFinalPosition(0f)
        }

        animationSecond3?.addEndListener { _, _, _, _ -> }
    }

    private fun setThirdAnimation() {

        animationThird1?.spring?.apply {
            dampingRatio = SpringForce.DAMPING_RATIO_NO_BOUNCY
            stiffness = 600f
        }

        animationThird2?.spring?.apply {
            dampingRatio = SpringForce.DAMPING_RATIO_NO_BOUNCY
            stiffness = 600f
        }

        animationThird3?.spring?.apply {
            dampingRatio = 0.4f
            stiffness = 600f
        }

        animationThird1?.addEndListener { _, _, _, _ ->
            animationThird2?.animateToFinalPosition(200f)
        }

        animationThird2?.addEndListener { _, _, _, _ ->
            animationThird3?.animateToFinalPosition(0f)
        }

        animationThird3?.addEndListener { _, _, _, _ ->
            animationFirst1?.animateToFinalPosition(-200f)
        }
    }

    fun detach() {
        firstCircle = null
        secondCircle = null
        thirdCircle = null

        animationFirst1?.removeEndListener(null)
        animationFirst2?.removeEndListener(null)
        animationFirst3?.removeEndListener(null)
        animationSecond1?.removeEndListener(null)
        animationSecond2?.removeEndListener(null)
        animationSecond3?.removeEndListener(null)
        animationThird1?.removeEndListener(null)
        animationThird2?.removeEndListener(null)
        animationThird3?.removeEndListener(null)

        animationFirst1 = null
        animationFirst2 = null
        animationFirst3 = null
        animationSecond1 = null
        animationSecond2 = null
        animationSecond3 = null
        animationThird1 = null
        animationThird2 = null
        animationThird3 = null
    }

    public override fun onDetachedFromWindow() {
        detach()
        super.onDetachedFromWindow()
    }
}