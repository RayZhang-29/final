$(document).ready(function ready() {
	var $inner = $('#inner'),
		$outer = $('#outer'),
		phases = ['Not Started', 'Capturing Phase', 'Targeting Phase', 'Bubbling Phase'];
	
	function displayPhase(event) {
		console.log('----------',event.currentTarget.id,'------------');
		console.log('Current Pahse:', phases[event.eventPhase]);
		console.log('Target:', event.target.id);
		console.log('');
	};

	$inner.click(function innerClickHandler(event) {
		// console.log(event.originalEvent);
		// console.log('inner clicked');
		displayPhase(event);
		// will stop event from propagating to the next element
		// event.stopPropagation();

		// will stop rest of the event listeners
		// event.stopImmediatePropagation();
		// console.log('123');
	});

	// event type + callback func
	$outer.on('click', function outerClickHandler(event) {
		// console.log('outer clicked');
		displayPhase(event);
	});

	// html ele
	$inner.get(0).addEventListener('click', function innerClickHandler(event) {
		// console.log('inner clicked');
		displayPhase(event);
	}); // /*useCapture*/true no use, capture phase: root to parent of ele

	$outer.get(0).addEventListener('click', function outerClickHandler(event) {
		// console.log('outer clicked in capturing');
		displayPhase(event);
	}, /*useCapture*/true);
});