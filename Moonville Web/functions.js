function init()
			{
				
				var stage = new createjs.Stage("boundary");
				var img_bit = new createjs.Bitmap();
				var bitmap = new createjs.Bitmap();

				boundary.width = window.innerWidth;
				boundary.height = window.innerHeight;
				
				circle = new createjs.Shape();
				stage.addChild(circle).setTransform(100,100).graphics.f("green").dc(0,0,50);
				stage.update();

				// display image
				var image = new Image();
				image.src = 'exa.png';
				image.onload = handleImageLoad(image, 0, 0);
				
				function handleImageLoad(x, a, b)
				{
					bitmap = new createjs.Bitmap(x);
					bitmap.x = a;
					bitmap.y = b;
					stage.addChild(bitmap);
					
					return bitmap;
				}(bitmap);
				
				stage.update();
				
				var dragger = new createjs.Container();
				
				dragger.x = dragger.y = 100;
				dragger.addChild(circle);
				stage.addChild(dragger);
				
				stage.addChild(dragger);
			
				dragger.addEventListener("mousedown", function(evt) {
					var offset = {x:evt.target.x-evt.stageX, y:evt.target.y-evt.stageY};
                 
					// add a handler to the event object's onMouseMove callback
					// this will be active until the user releases the mouse button:
					evt.addEventListener("mousemove",function(ev) 
					{
						ev.target.x = ev.stageX+offset.x;
						ev.target.y = ev.stageY+offset.y;
						stage.update();   
					});
				});
				
				stage.update();
			}		