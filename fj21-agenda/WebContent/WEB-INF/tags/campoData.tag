<%@ attribute name="id" required="true" %>
<%@ attribute name="name" required="false" %>

<input type="text" id="${id}" name="${id}"/>
<script>
	$("#${id}").datepicker({dateFormat:'dd/mm/yy'});
</script>