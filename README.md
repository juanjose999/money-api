# Sistema de Administración de Préstamos de Dinero

- Agregar nuevos clientes al sistema.
- Revisar una lista completa de clientes registrados.
- Ver detalles específicos de cada cliente, incluyendo su historial de préstamos.
- Aprobar o rechazar solicitudes de préstamos.
- Ver una lista de solicitudes de préstamos pendientes.
- Registrar los pagos realizados por los clientes.
- Generar informes financieros sobre el estado de la empresa.
- Enviar notificaciones automáticas a los clientes sobre vencimientos de pagos y cambios en el estado de sus préstamos.
- Modificar los términos de los préstamos existentes según sea necesario.

Este sistema es una herramienta crucial para la gestión eficiente de los préstamos de dinero y facilita el seguimiento de los clientes, las solicitudes de préstamos y los pagos realizados.

# Admin:
Atributos: ID, nombre, apellido, dirección, número de teléfono, correo electrónico, fecha de registro.
Relaciones: Puede tener agregar de uno a muchos con la entidad usuarios.

# Cliente:
Atributos: ID, nombre, apellido, dirección, número de teléfono, correo electrónico, fecha de registro.
Relaciones: Puede tener una relación de uno a muchos con la entidad de Préstamo.

# Préstamo:
Atributos: ID, monto del préstamo, tasa de interés, fecha de inicio, fecha de vencimiento, estado (aprobado, pendiente, rechazado, etc.), monto pendiente, ID del cliente asociado.
Relaciones: Puede tener una relación de muchos a uno con la entidad de Cliente.

# Pago:
Atributos: ID, monto del pago, fecha del pago, ID del préstamo asociado.
Relaciones: Puede tener una relación de muchos a uno con la entidad de Préstamo.

# Factyra pago:
Atributos: ID, tipo de informe, fecha de generación, detalles del informe (p. ej., ingresos por intereses, préstamos pendientes, pagos realizados, etc.).