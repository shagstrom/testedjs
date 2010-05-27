document.observe('dom:loaded', function() {
	$$('div.tree.root').each(function(tree){
		new DynamicTree(tree);
	});
});
