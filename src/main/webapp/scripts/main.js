window.onload = function() {
	RowSelector.bindEvents();
	$$('div.tree').each(function(tree) {
		new DynamicTree(tree);
	});
}