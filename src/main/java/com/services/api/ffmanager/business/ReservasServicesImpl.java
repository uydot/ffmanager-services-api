package com.services.api.ffmanager.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.api.ffmanager.domain.dto.StockMaterialDTO;
import com.services.api.ffmanager.domain.entities.ActividadesDeReserva;
import com.services.api.ffmanager.domain.entities.Areas;
import com.services.api.ffmanager.domain.entities.Complejos;
import com.services.api.ffmanager.domain.entities.Estados;
import com.services.api.ffmanager.domain.entities.EstadosDeSectores;
import com.services.api.ffmanager.domain.entities.Materiales;
import com.services.api.ffmanager.domain.entities.MaterialesDeReserva;
import com.services.api.ffmanager.domain.entities.ReservaDeSector;
import com.services.api.ffmanager.domain.entities.Reservas;
import com.services.api.ffmanager.domain.entities.Sectores;
import com.services.api.ffmanager.domain.repository.ActividadesDeReservaRepository;
import com.services.api.ffmanager.domain.repository.AreasRepository;
import com.services.api.ffmanager.domain.repository.ComplejosRepository;
import com.services.api.ffmanager.domain.repository.EstadosDeSectoresRepository;
import com.services.api.ffmanager.domain.repository.EstadosRepository;
import com.services.api.ffmanager.domain.repository.MaterialesDeReservaRepository;
import com.services.api.ffmanager.domain.repository.MaterialesRepository;
import com.services.api.ffmanager.domain.repository.ReservaDeSectorRepository;
import com.services.api.ffmanager.domain.repository.ReservasRepository;
import com.services.api.ffmanager.domain.repository.SectoresRepository;
import com.services.api.ffmanager.utils.Utilities;

@Service
public class ReservasServicesImpl implements ReservasServices {

	SectoresRepository sectoresRepository;
	ReservasRepository reservasRepository;
	ReservaDeSectorRepository reservaDeSectorRepository;
	MaterialesDeReservaRepository materialesDeReservaRepository;
	ActividadesDeReservaRepository actividadesDeReservaRepository;
	EstadosDeSectoresRepository estadoDeSectorRepository;
	EstadosRepository estadosRepository;
	AreasRepository areasRepository;
	ComplejosRepository complejosRepository;
	MaterialesRepository materialesRepository;

	@Autowired
	public ReservasServicesImpl(SectoresRepository sectoresRepository, ReservasRepository reservasRepository,
			ReservaDeSectorRepository reservaDeSectorRepository,
			MaterialesDeReservaRepository materialesDeReservaRepository,
			ActividadesDeReservaRepository actividadesDeReservaRepository,
			EstadosDeSectoresRepository estadoDeSectorRepository, EstadosRepository estadosRepository,
			AreasRepository areasRepository, ComplejosRepository complejosRepository,
			MaterialesRepository materialesRepository) {
		this.reservasRepository = reservasRepository;
		this.sectoresRepository = sectoresRepository;
		this.reservaDeSectorRepository = reservaDeSectorRepository;
		this.materialesDeReservaRepository = materialesDeReservaRepository;
		this.actividadesDeReservaRepository = actividadesDeReservaRepository;
		this.estadoDeSectorRepository = estadoDeSectorRepository;
		this.estadosRepository = estadosRepository;
		this.areasRepository = areasRepository;
		this.complejosRepository = complejosRepository;
		this.materialesRepository = materialesRepository;
	}

	@Override
	public HashMap<String, List<Sectores>> getAllSectoresDisponibles(Integer idArea, LocalDateTime fechaDesde,
			LocalDateTime fechaHasta) {
		Collection<Sectores> listResult = (Collection<Sectores>) reservasRepository.getAllSectoresDisponibles(idArea);
		Collection<Sectores> sectores = new ArrayList<Sectores>();
		for (Sectores o : listResult) {

			Set<EstadosDeSectores> ultimoEstadoEnLista = new HashSet<EstadosDeSectores>();
			EstadosDeSectores ultimoEstado = getUltimoEstado(o.getEstadosDeSectores());

			if (ultimoEstado != null) {// Si encuentro estados de un sector, me quedo con el ultimo y cargo sus
										// valores, luego valido si ese estado corresponde dentro del rango de fechas
										// solicitado
			
				ultimoEstadoEnLista.add(ultimoEstado);
				o.setEstadosDeSectores(ultimoEstadoEnLista);
				o.setIdEstadoSector(ultimoEstado.getEstados().getIdEstado());
				o.setColor(ultimoEstado.getEstados().getColor());
				o.setSePuedeUtilizar(ultimoEstado.getEstados().isPermiteUsar());// Indico si se puede utilizar o no el
																		// sector, esto define si el sector esta
																				// sin daños
			}

			else {
				//o.setColor(_colorDisponible);
				o.setSePuedeUtilizar(true);
			}

			sectores.add(o);
		}

		return getSectoresReservados(sectores, fechaDesde, fechaHasta);
	}

	// Devuelve el estado ultimo del sector
	private EstadosDeSectores getUltimoEstado(Collection<EstadosDeSectores> estados) {
		if (estados != null && !estados.isEmpty()) {
			EstadosDeSectores result = estados.iterator().next();// Me quedo con el primer estado
			for (EstadosDeSectores estadosDeSectores : estados) {
				if (Utilities.compareLocalDateTime(estadosDeSectores.getFechaAsignado(),
						result.getFechaAsignado()) > 0) {// Comparo las fechas, y me quedo con el mas nuevo
					result = estadosDeSectores;
				}
			}
			return result;
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	private HashMap<String, List<Sectores>> getSectoresReservados(Collection<Sectores> sectores,
			LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
		HashMap<String, List<Sectores>> hashResultado = new HashMap<String, List<Sectores>>();
		List<Sectores> sectoresOcupados = new ArrayList<Sectores>();
		List<Sectores> sectoresLibres = new ArrayList<Sectores>();
		Estados estadoReservado = estadosRepository.getEstadoReservado();
		for (Sectores s : sectores) {

			Collection<Integer> ids = reservasRepository.isOcupado(s.getIdSector(), fechaDesde, fechaHasta);
			if (ids != null && !ids.isEmpty()) {// Si devuelve el id del sector, entonces en ese rango de horas el sector esta
								// ocupado
				Reservas r  = null;
				for (int i = 0; i < 1; i++) {
					r = reservasRepository.getOne(ids.iterator().next());//Me quedo con la primer reserva, ya que siempre se lo llama con ventana de 1 hora cuando se quiere ver el estado de las areas 
				}
				s.setColor(estadoReservado.getColor());
				s.setSePuedeUtilizar(false);
				s.setUsuarioReserva(r != null ? r.getUsuarioReserva() : "");
				sectoresOcupados.add(s);
				
			} else if (s.getSePuedeUtilizar()) {//Si el sector se puede utilizar lo marco como disponible, sino lo dejo como estaba, ya que no se puede utilizar por daños 
				s.setColor(_colorDisponible);
				s.setSePuedeUtilizar(true);
				s.setUsuarioReserva("");
				sectoresLibres.add(s);
				
			}else {//Lo agrego en libre, pero en realidad es el estado donde el sector no esta disponible por daños
				sectoresLibres.add(s);
			}
		}
		hashResultado.put(_libres, sectoresLibres);
		hashResultado.put(_ocupados, sectoresOcupados);

		return hashResultado;
	}

	@Override
	public void seleccionarSectores(Collection<Reservas> reservas) {
		// TODO Auto-generated method stub
	}

	@Override
	public void createReservaDeSector(ReservaDeSector reserva) {
		reservaDeSectorRepository.save(reserva);
	}

	@Override
	public Reservas createReserva(Reservas reserva) {
		return reservasRepository.save(reserva);
	}

	@Override
	public void createMaterialesDeReserva(MaterialesDeReserva materiales) {
		materialesDeReservaRepository.save(materiales);
	}

	@Override
	public void createActividadesDeReserva(ActividadesDeReserva actividades) {
		actividadesDeReservaRepository.save(actividades);
	}

	@Override
	public void setEstadoSector(Integer sector, Integer estado) {

		Sectores s = sectoresRepository.getById(sector);
		Estados e = estadosRepository.getById(estado);
		EstadosDeSectores eds = new EstadosDeSectores();
		eds.setEstados(e);
		eds.setSectores(s);
		eds.setFechaAsignado(Utilities.getNowLocalDateTime());

		estadoDeSectorRepository.save(eds);

	}

	@Override
	public HashMap<String, Areas> getAllAreasDisponibles(Integer idComplejo, LocalDateTime fechaDesde,
			LocalDateTime fechaHasta) {

		Complejos complejo = complejosRepository.getById(idComplejo);

		HashMap<String, Areas> hashAreas = new HashMap<String, Areas>();

		for (Areas area : complejo.getAreas()) {
			hashAreas.put("Area " + area.getIdArea() + " tiene estos Sectores libres "
					+ ((HashMap<String, List<Sectores>>) (getAllSectoresDisponibles(area.getIdArea(), fechaDesde,
							fechaHasta))).get(_libres).size(),
					area);

		}

		return hashAreas;
	}

	@Override
	public HashMap<String, String> getUsoDeHorasDeAreaSimple(Integer idArea, LocalDateTime fecha, String[] horas) {

		Collection<Sectores> listResult = (Collection<Sectores>) reservasRepository.getAllSectoresDisponibles(idArea);
		Sectores sectorResultado = null;
		for (Sectores o : listResult) {// solo devuelve 1 sector
			sectorResultado = o;
			EstadosDeSectores ultimoEstado = getUltimoEstado(o.getEstadosDeSectores());
			if (ultimoEstado != null) {
				sectorResultado.setIdEstadoSector(ultimoEstado.getEstados().getIdEstado());
				o.setColor(ultimoEstado.getEstados().getColor());
				o.setSePuedeUtilizar(ultimoEstado.getEstados().isPermiteUsar());
			} else {
				o.setColor(_colorDisponible);
				o.setSePuedeUtilizar(true);
			}

		}
		return getHorasReservadas(sectorResultado, fecha, horas);
	}

	private HashMap<String, String> getHorasReservadas(Sectores sector, LocalDateTime fecha, String[] horas) {
		HashMap<String, String> hashResultado = new LinkedHashMap<String, String>();

		for (int i = 0; i < horas.length - 1; i++) {

			// Si devuelve el id del sector, entonces en ese rango de horas el sector esta
			// ocupado
			Collection<Integer> ids = reservasRepository.isOcupado(sector.getIdSector(),
					Utilities.getDateTimeAt(Integer.parseInt(horas[i]), fecha),
					Utilities.getDateTimeAt(Integer.parseInt(horas[i + 1]), fecha));
			if (ids != null && !ids.isEmpty()) {
				hashResultado.put("" + horas[i] + "-" + horas[i + 1], "ocupado");
			} else {
				hashResultado.put("" + horas[i] + "-" + horas[i + 1], "libre");
			}
		}
		return hashResultado;
	}

	/*
	 * Devuelve un Hash que tiene como key el id del material, y como value el stock
	 * disponible en las fechas dadas
	 */
	public List<StockMaterialDTO> getStockMaterialesPorReserva(LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
		List<StockMaterialDTO> listaMaterialStock = new ArrayList<StockMaterialDTO>();

		HashMap<String, Integer> hashMaterialStockAUX = new HashMap<String, Integer>();
		List<Materiales> materiales = materialesRepository.findAll();
		for (Materiales mat : materiales) {
			hashMaterialStockAUX.put("" + mat.getIdMaterial() + "-" + mat.getNombre(), mat.getStock());
		}

		List<Object> result = (List<Object>) reservasRepository.getMaterialesDeReserva(fechaDesde, fechaHasta);

		// Creo un hash para calcular el stock de cada material
		for (Object valores : result) {
			Object idMaterial = ((Object[]) valores)[0];
			Object nombre = ((Object[]) valores)[3];
			Object gasto = ((Object[]) valores)[2];

			hashMaterialStockAUX.put("" + (Integer) idMaterial + "-" + (String) nombre,
					((Integer) hashMaterialStockAUX.get("" + idMaterial + "-" + nombre)) - (Integer) gasto);
		}

		// Itero sobre el hash de materiales con su stock, para generar una lista de
		// objetos StockMaterialDTO
		StockMaterialDTO sDTO;
		for (var entry : hashMaterialStockAUX.entrySet()) {
			String id_nombre_String = entry.getKey();
			String[] id_nombre_Array = id_nombre_String.split("-");
			Integer stock = entry.getValue();

			sDTO = new StockMaterialDTO();

			sDTO.setIdMaterial(Integer.parseInt(id_nombre_Array[0]));
			sDTO.setNombre(id_nombre_Array[1]);
			sDTO.setStock(stock);
			listaMaterialStock.add(sDTO);
		}

		return listaMaterialStock;
	}

	@Override
	public Estados getEstadoReservado() {
		return estadosRepository.getEstadoReservado();
	}

}
