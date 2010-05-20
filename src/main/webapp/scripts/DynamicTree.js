var DynamicTree = Class.create({
	
	initialize: function(element) {
		this.element = $(element);
		this.bindEvent();
	},
	
	bindEvent: function() {
		this.element.observe('click', this.clickHandler.bind(this));
	},
	
	clickHandler: function(event) {
		var target = event.element();
		if (target.hasClassName('node')) {
			var children = target.next('.children');
			if (children.down('.branch')) {
				this.removeChildren(children);
			} else {
				this.addChildren(children);
			}
		}
	},
	
	removeChildren: function(children) {
		children.innerHTML = '';
	},
	
	addChildren: function(children) {
		var request = new Ajax.Request(window.location.href, {
			parameters: {
				action: 'getChildren'
			},
			onSuccess: function(transport) {
				children.innerHTML = transport.responseText;
			}
		});
	}

});
