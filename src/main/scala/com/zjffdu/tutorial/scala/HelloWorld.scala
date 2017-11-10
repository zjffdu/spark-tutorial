package com.zjffdu.tutorial.scala

import com.google.gson.Gson
import org.apache.spark.repl.SparkILoop

import scala.tools.nsc.Settings
import scala.tools.nsc.interpreter.InteractiveReader


class A(val name: String) {
  def f: Unit =println(name)
}
class B(override val name: String = "") extends A(name) {
  val a: String = "hello"

  def g: Unit=println(name)
}


import java.io.File


import breeze.linalg._
import breeze.plot.Figure
import io.continuum.bokeh._



object IrisSource extends ColumnDataSource {

  val colormap = Map[Int, Color](0 -> Color.Red, 1 ->
    Color.Green, 2 -> Color.Blue)
  val iris = csvread(file = new File("/Users/jzhang/iris.data"), separator = ',')
  val sepalLength = column(iris(::, 0))
  val sepalWidth = column(iris(::, 1))
  val petalLength = column(iris(::, 2))
  val petalWidth = column(iris(::, 3))
  val species = column(iris(::,4))
  val speciesColor = column(species.value.map(v =>
    colormap(v.round.toInt)))
}

object Bokeh_Scala extends  App{

  import IrisSource.{colormap,sepalLength,sepalWidth,petalLength,petalWidth, speciesColor}

  val plot = new Plot().title("Iris Petal Length vs Width")
  val diamond = new Diamond()
    .x(petalLength)
    .y(petalWidth)
    .fill_color(Color.Blue)
    .fill_alpha(0.5)
    .size(5)

  val dataPointRenderer = new GlyphRenderer().data_source(IrisSource).glyph(diamond)

  val xRange = new DataRange1d().sources(petalLength :: Nil)
  val yRange = new DataRange1d().sources(petalWidth :: Nil)

  plot.x_range(xRange).y_range(yRange)

  //X and Y Axis
  val xAxis = new LinearAxis().plot(plot).axis_label("Petal Length").
    bounds((1.0, 7.0))
  val yAxis = new LinearAxis().plot(plot).axis_label("Petal Width").
    bounds((0.0, 2.5))
  plot.below <<= (listRenderer => (xAxis :: listRenderer))
  plot.left <<= (listRenderer => (yAxis :: listRenderer))

  val xgrid = new Grid().plot(plot).axis(xAxis).dimension(0)
  val ygrid = new Grid().plot(plot).axis(yAxis).dimension(1)



  //Adding Legend
  val setosa = new Diamond().fill_color(Color.Red).size(10).fill_alpha(0.5)
  val setosaGlyphRnd=new GlyphRenderer().glyph(setosa)
  val versicolor = new Diamond().fill_color(Color.Green).size(10).fill_alpha(0.5)
  val versicolorGlyphRnd=new GlyphRenderer().glyph(versicolor)
  val virginica = new Diamond().fill_color(Color.Blue).size(10).fill_alpha(0.5)
  val virginicaGlyphRnd=new GlyphRenderer().glyph(virginica)

  val legends = List("setosa" -> List(setosaGlyphRnd), "versicolor" -> List(versicolorGlyphRnd), "virginica" -> List(virginicaGlyphRnd))
  val legend = new Legend().orientation(LegendOrientation.TopLeft).plot(plot).legends(legends)

  plot.renderers := List[Renderer](xAxis, yAxis, dataPointRenderer, xgrid, ygrid, legend, setosaGlyphRnd, virginicaGlyphRnd, versicolorGlyphRnd)




  //Add the renderer to the plot
  //plot.renderers := List[Renderer](xAxis, yAxis, dataPointRenderer, xgrid, ygrid)


  val panTool = new PanTool().plot(plot)
  val wheelZoomTool = new WheelZoomTool().plot(plot)
  val previewSaveTool = new PreviewSaveTool().plot(plot)
  val resetTool = new ResetTool().plot(plot)
  val resizeTool = new ResizeTool().plot(plot)
  val crosshairTool = new CrosshairTool().plot(plot)
  plot.tools := List(panTool, wheelZoomTool, previewSaveTool, resetTool, resizeTool, crosshairTool)

  val document = new Document(plot)
  val file = document.save("/Users/jzhang/IrisBokehBreeze.html")
  file.view()

}// Object Bokeh_Scala ends here
